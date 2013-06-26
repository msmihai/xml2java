package org.xml2java.internal.model;

import java.util.ArrayList;

public class XModel {
    public ArrayList<XClass> classList = new ArrayList<>();
    
    public XClass getClassByName(String clazz)
    {
        for (XClass cc : classList)
        {
            if ( cc.name.equals(clazz))
            {
                return cc;
            }
        }
        
        return null;
    }
}
