package org.xml2java.internal.model;

import java.util.ArrayList;

public class XClass {

    public String name;
    public ArrayList<XField> fieldList = new ArrayList<>();

    public XClass(String name) {
        this.name = name;
    }

    public XField getFieldByName(String fieldName) {
        for (XField ff : fieldList) {
            if (ff.name.equals(fieldName)) {
                return ff;
            }
        }

        return null;
    }
}
