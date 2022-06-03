package problem01;

import problem01.part.Part;
import problem01.part.commChannel.CommChannel;
import problem01.part.commModule.CommModule;

import java.util.LinkedList;

class Product {
    private final LinkedList<Part> parts;

    Product() {
        parts = new LinkedList<>();
    }

    void addPart(Part part) {
        parts.addLast(part);
    }

    void showParts() {
        double totalPrice = 0;
        double totalyearlyCharge = 0;

        System.out.println("This product has the following parts -");
        System.out.printf("%-48s %8s%28s\n","[Name - Description]", "[Price]", "[Yearly Charge]");
        for(int i=0; i<parts.size(); i++) {
            Part part = parts.get(i);
            if(!(part instanceof CommChannel)) {
                totalPrice += part.getPrice();
                System.out.printf("%-48s %8.2f$\n", ((i+1) + ". " + part.getDescription()), part.getPrice());
            } else {
                totalyearlyCharge += part.getPrice();
                System.out.printf("%-48s %24s%8.2f\n", ((i+1) + ". " + part.getDescription()), "$", part.getPrice());
            }
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-48s $%8.2f\n", "Total Price", totalPrice);
        System.out.printf("%-48s %24s%8.2f\n", "Total Yearly Charge", "$", totalyearlyCharge);
    }
}
