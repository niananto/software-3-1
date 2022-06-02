package problem02idea01;

import problem02idea01.Editor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editor editor = Editor.getEditor();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String [] tokens = s.split("\\.");
            String ext = tokens[tokens.length-1];
//        System.out.println(ext);

//            try {
//                editor.setEnv(new EnvironmentFactory().getEnvironment(ext));
//                editor.printDescription();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    }
}
