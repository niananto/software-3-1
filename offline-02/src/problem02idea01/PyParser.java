package problem02idea01;

class PyParser implements Parser{
    @Override
    public String parse() {
        return "parsing python files";
    }

    @Override
    public String match(String string) {
        return "matching python strings";
    }

    @Override
    public String toString() {
        return "Python";
    }
}
