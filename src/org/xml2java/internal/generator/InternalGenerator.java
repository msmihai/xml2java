package org.xml2java.internal.generator;

import org.xml2java.internal.model.XClass;

public class InternalGenerator {
    protected XClass xClazz;
    protected String packageName;
    
    private static final String ENDL = System.lineSeparator();
    
    protected void generate(StringBuilder out)
    {
        /* package section */
        
        out.append("package " + packageName + ";" + ENDL);
        out.append(ENDL);
        
        /* imports section */
        
        
        
    }
    
}
