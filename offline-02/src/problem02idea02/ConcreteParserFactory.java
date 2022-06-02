package problem02idea02;

class ConcreteParserFactory implements IParserFactory {
    public Parser getParser(String lang) throws Exception {
        if(lang.equalsIgnoreCase("c")) {
            return new CParser();
        } else if(lang.equalsIgnoreCase("cpp")) {
            return new CppParser();
        } else if(lang.equalsIgnoreCase("py")) {
            return new PyParser();
        } else {
            throw new Exception("not a supported language");
        }
    }
}
