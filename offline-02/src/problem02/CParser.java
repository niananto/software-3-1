package problem02;

class CParser implements Parser{
    @Override
    public String parse() {
        return "parsing c files";
    }

    @Override
    public String match(String string) {
        return "matching c strings";
    }
}
