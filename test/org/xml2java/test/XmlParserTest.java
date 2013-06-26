/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xml2java.test;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml2java.internal.parser.XmlParser;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml2java.internal.model.XClass;
import org.xml2java.internal.model.XField;
import org.xml2java.internal.model.XModel;

/**
 *
 * @author Mihai
 */
public class XmlParserTest {

    @Test
    public void test1() throws Exception {
        File fXmlFile = new File("input1.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        XmlParser xmlParser = new XmlParser(doc);
        
        xmlParser.parseXmlToModel();
        
        XModel xModel = xmlParser.getxModel();
        
        System.out.println(xModel.classList.size());
        
        for( XClass xc : xModel.classList)
        {
            System.out.println(xc.name);
            
            for (XField field : xc.fieldList)
            {
                System.out.println(field.name + " - " + field.type);
            }
        }
        
    }
}