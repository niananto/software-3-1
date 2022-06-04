package problem02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editor editor = Editor.getEditor();
        EnvironmentFactory environmentFactory;

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String [] tokens = s.split("\\.");
            String ext = tokens[tokens.length-1];

            if(ext.equalsIgnoreCase("c")) {
                environmentFactory = new CEnvironmentFactory();
            } else if(ext.equalsIgnoreCase("cpp")) {
                environmentFactory = new CppEnvironmentFactory();
            } else if(ext.equalsIgnoreCase("py")) {
                environmentFactory = new PyEnvironmentFactory();
            } else {
                System.out.println("no extension matched");
                continue;
            }

            editor.setEnvironment(environmentFactory.getEnvironment());
            editor.describeCurrentEnvironment();
        }
    }
}
