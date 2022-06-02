package problem02idea02;

public class Editor {
//    singleton

//    Assume that multiple instances of the
//    editor cannot run simultaneously

    private static Editor editor = null;
    private Parser parser;
    private Font font;

    private Editor() {}

    private Editor(String lang, String font) {
        try {
            this.parser = new ConcreteParserFactory().getParser(lang);
            this.font = new ConcreteFontFactory().getFont(font);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Editor getEditor(String lang, String font) {
        if(editor == null) {
            editor = new Editor(lang, font);
            System.out.println("New editor instantiated");
        } else {
            System.out.println("Editor exists");
        }

        return editor;
    }
}
