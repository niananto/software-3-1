package problem01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        String[] tokens;

        Product product;

        // builder pattern first
//        Director director = new Director();
//
//        IBuilder deluxeBuilder = new Deluxe();
//        IBuilder optimalBuilder = new Optimal();
//        IBuilder poorBuilder = new Poor();
////
//        while(sc.hasNextLine()) {
//            s = sc.nextLine();
//            tokens = s.split(" ");
//
//            try {
//                if (tokens[0].equalsIgnoreCase("deluxe")) {
//                    director.construct(deluxeBuilder, tokens[1], Integer.parseInt(tokens[2]));
//                    product = deluxeBuilder.getQMS();
//                    product.showParts();
//                } else if (tokens[0].equalsIgnoreCase("optimal")) {
//                    director.construct(optimalBuilder, tokens[1], Integer.parseInt(tokens[2]));
//                    product = optimalBuilder.getQMS();
//                    product.showParts();
//                } else if (tokens[0].equalsIgnoreCase("poor")) {
//                    director.construct(poorBuilder, tokens[1], Integer.parseInt(tokens[2]));
//                    product = poorBuilder.getQMS();
//                    product.showParts();
//                } else {
//                    System.out.println("don't match any build type");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }


        // then a factory to build every type of them
        FactoryForBuilders factory = new FactoryForBuilders();
        while(sc.hasNextLine()) {
            s = sc.nextLine();
            tokens = s.split(" ");

            try {
                product = factory.getBuild(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                product.showParts();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
