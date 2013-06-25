package org.xml2java.internal.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml2java.internal.model.XModel;

public class XmlParser {
    private Document xmlDoc;
    private XModel xModel = new XModel();

    public XmlParser(Document xmlDoc) {
        this.xmlDoc = xmlDoc;
    }
    
    private void processNode(Element element)
    {
        
    }
    
    public XModel parseXmlToModel()
    {   
        
        return xModel;
    }
    
}
