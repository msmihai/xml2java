package org.xml2java.internal.parser;

import java.util.HashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml2java.internal.model.XClass;
import org.xml2java.internal.model.XField;
import org.xml2java.internal.model.XFieldType;
import org.xml2java.internal.model.XModel;

public class XmlParser {

    private Document xmlDoc;
    private XModel xModel = new XModel();
    

    public XModel getxModel() {
        return xModel;
    }

    public XmlParser(Document xmlDoc) {
        this.xmlDoc = xmlDoc;
    }

    private void processNode(Element element) {
        /* add a new class if it doesn't exist already */

        XClass currentClass = xModel.getClassByName(element.getNodeName());

        if (currentClass == null) {
            currentClass = new XClass(element.getNodeName());
            xModel.classList.add(currentClass);
        }
        

        /* process it's attributes and add them the respective class as field members of type string*/

        NamedNodeMap nnm = element.getAttributes();

        for (int i = 0; i < nnm.getLength(); i++) {
            Node node = nnm.item(i);

            XField currentField = currentClass.getFieldByName(node.getNodeName());

            if (currentField == null) {
                currentClass.fieldList.add(new XField(node.getNodeName(), XFieldType.STRING));
            }


        }


        /*
         * for example <a> <b>...</b> <b>..</b> <c>...</c> </a>
         * then in this map there will be {b,2} {c,1}
         */

        HashMap<String, Integer> uniqueChildrenCountMap = new HashMap<>();

        NodeList nl = element.getChildNodes();

        /* process children nodes */

        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);

            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Integer value;
                if ((value = uniqueChildrenCountMap.get(node.getNodeName())) == null) {
                    uniqueChildrenCountMap.put(node.getNodeName(), 1);
                } else {
                    uniqueChildrenCountMap.put(node.getNodeName(), value + 1);
                }

                processNode((Element) node);
            } else {
            }

        }
        
        /* after all children have been processed, decide what type of ref to add to the parent */
        
        for ( String str : uniqueChildrenCountMap.keySet())
        {
            XField newField = new XField();
            newField.name = str;
            newField.type = (uniqueChildrenCountMap.get(str) > 1)? XFieldType.LIST_OF_CLASS_REF : XFieldType.CLASS_REF;
            
            currentClass.fieldList.add(newField);
            
        }

    }

    public XModel parseXmlToModel() {
        processNode(xmlDoc.getDocumentElement());
        return xModel;
    }
}
