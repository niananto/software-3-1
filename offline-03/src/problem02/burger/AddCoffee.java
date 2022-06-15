package problem02.burger;

public class AddCoffee extends BurgerDecorator{
    public AddCoffee(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 60;
    }
}
