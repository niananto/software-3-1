package problem02idea01;

class CParser implements Parser{
    @Override
    public String parse() {
        return "parsing c files";
    }

    @Override
    public String match(String string) {
        return "matching c strings";
    }

    @Override
    public String toString() {
        return "C";
    }
}
