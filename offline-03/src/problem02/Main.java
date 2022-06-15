package problem02;

import problem02.burger.*;

public class Main {
    public static void main(String[] args) {
        Burger beefFrenchCheese = new AddCheese(new AddFrenchFries(new BeefBurger()));
        System.out.println("1. Beef Burger with French Fry and Cheese - " + beefFrenchCheese.getPrice());

        Burger veggiOnionWater = new AddWater(new AddOnionRings(new VeggiBurger()));
        System.out.println("2. Veggi Burger with Onion Rings and Bottle of Water - " + veggiOnionWater.getPrice());

        Burger comboVeggiFrenchCoke = new AddCoke(new AddFrenchFries(new VeggiBurger()));
        System.out.println("3. A Combo Meal with Veggi Burger, French Fry and Coke - " + comboVeggiFrenchCoke.getPrice());

        Burger comboVeggiOnionCoffeeWater = new AddWater(new AddCoffee(new AddOnionRings(new VeggiBurger())));
        System.out.println("4. A Combo Meal with Veggi Burger, Onion Rings, Coffee and Water - " + comboVeggiOnionCoffeeWater.getPrice());

        Burger beef = new BeefBurger();
        System.out.println("5. A Beef Burger only - " + beef.getPrice());
    }
}
