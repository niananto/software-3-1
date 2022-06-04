package problem02idea01;

public class Editor {
//    singleton

//    Assume that multiple instances of the
//    editor cannot run simultaneously

    private static Editor editor = null;
    private Environment environment;

    private Editor() {

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

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void describeCurrentEnvironment() {
        environment.describeEnv();
    }
}
