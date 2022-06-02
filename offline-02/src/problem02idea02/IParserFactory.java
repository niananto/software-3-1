package problem02idea02;

public interface IParserFactory {
    public Parser getParser(String lang) throws Exception;
}
