package problem02idea02;

class CppParser implements Parser {
    @Override
    public String parse() {
        return "parsing cpp files";
    }

    @Override
    public String match(String string) {
        return "matching cpp strings";
    }
}
