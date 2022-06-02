package problem02idea03;

public class Editor {
//    singleton

//    Assume that multiple instances of the
//    editor cannot run simultaneously

    private static Editor editor = null;
    private Environment env;

    private Editor() {}

    public void setEnv(Environment env) {
        this.env = env;
    }

    public static Editor getEditor() {
        if(editor == null) {
            editor = new Editor();
            System.out.println("New editor instantiated");
        } else {
            System.out.println("Editor exists");
        }

        return editor;
    }

    public void printDescription() {
        env.describeEnvironment();
    }
}
