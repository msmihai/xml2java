package org.xml2java.internal.model;

public class XField {

    public String name;
    public XFieldType type;
    public XClass classRef;

    public XField() {
    }

    public XField(String name, XFieldType type) {
        this.name = name;
        this.type = type;
    }
    
    

    public String getFieldDeclaration() {
        String ret = "/* Fatal error parsing field */";

        switch (type) {
            case STRING:
                ret = "public String " + name + ";";
                break;
            case LIST_OF_STRING:
                ret = "public ArrayList<String> " + name + ";";
                break;
            case CLASS_REF:
                ret = "public " + classRef.name + " " + name + ";";
                break;
            case LIST_OF_CLASS_REF:
                ret = "public ArrayList<" + classRef.name + "> " + name + ";";
                break;
        }

        return ret;

    }
}
