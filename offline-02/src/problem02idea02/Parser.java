package problem02idea02;

public interface Parser {
//    interface for c, cpp, py parsers to implement

//    All the parsers implement an interface named Parser which
//    contains all the functions required to parse a
//    file.

    String parse(); // modifier public is redundant for interface members
    String match(String string);
}
