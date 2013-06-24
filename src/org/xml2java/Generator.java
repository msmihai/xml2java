package org.xml2java;

public class Generator {

    private String packageName;
    private String outputFolderPath;
    private String inputXmlPath;

    public static class GeneratorException extends RuntimeException {
        private String reason;

        public GeneratorException(String reason, String message) {
            super(message);
            this.reason = reason;
        }
    }

    public void generate() throws GeneratorException{
        
    }
}
