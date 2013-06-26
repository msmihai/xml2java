/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xml2java.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml2java.internal.generator.InternalGenerator;
import org.xml2java.internal.model.XClass;
import org.xml2java.internal.model.XField;
import org.xml2java.internal.model.XFieldType;

/**
 *
 * @author Mihai
 */
public class InternalGeneratorTest {

    @Test
    public void test1() {
        XClass xClazz = new XClass("Book");
        xClazz.fieldList.add(new XField("name", XFieldType.STRING));
        xClazz.fieldList.add(new XField("author", XFieldType.STRING));
        InternalGenerator ig = new InternalGenerator(xClazz, "com.book");
        
        StringBuilder sb = new StringBuilder();
        
        ig.generate(sb);
        
        System.out.println(sb.toString());
        
    }
}