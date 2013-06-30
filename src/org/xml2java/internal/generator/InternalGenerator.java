package org.xml2java.internal.generator;

import org.xml2java.internal.model.XClass;
import org.xml2java.internal.model.XField;

public class InternalGenerator {

    protected XClass xClazz;
    protected String packageName;
    /* for future, let user choose what ENDL should be? */
    private static final String ENDL = System.lineSeparator();
    /* for future, let user choose what tab should be? */
    private static final String TAB = "    ";

    public InternalGenerator() {
    }

    public InternalGenerator(XClass xClazz, String packageName) {
        this.xClazz = xClazz;
        this.packageName = packageName;
    }

    /* Decorator class that auto-inserts endlines and tabs */
    private class SmartStringBuilder {

        private StringBuilder sb;
        private int tabIndex = 0;

        public SmartStringBuilder(StringBuilder sb) {
            this.sb = sb;
        }

        public void append() {
            sb.append(ENDL);
        }

        public void append(String content) {
            if (!content.equals("")) {

                for (int i = 0; i < tabIndex; i++) {
                    sb.append(TAB);
                }

                sb.append(content);
            }
            sb.append(ENDL);
        }
    }

    public void generate(StringBuilder out) {

        SmartStringBuilder ssb = new SmartStringBuilder(out);

        /* package section */

        ssb.append("package " + packageName + ";");
        ssb.append();

        /* imports section */
        /* TODO add imports section */

        /* class definition start */

        ssb.append("public class " + xClazz.name);
        ssb.append("{");

        ssb.tabIndex++;

        /* create fields */

        for (XField field : xClazz.fieldList) {
            ssb.append(field.getFieldDeclaration());
        }

        /* class definition end */

        ssb.tabIndex--;
        
        ssb.append("}");

    }
}
