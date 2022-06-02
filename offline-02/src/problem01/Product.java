package problem01;

import java.util.LinkedList;

class Product {
    private final LinkedList<String> parts;

    Product() {
        parts = new LinkedList<>();
    }

    void addPart(String part) {
        parts.addLast(part);
    }

    void showParts() {
        System.out.println("This product has the following parts -");
        for(int i=0; i<parts.size(); i++) {
            System.out.println(i+1 + ". " + parts.get(i));
        }
    }
}
