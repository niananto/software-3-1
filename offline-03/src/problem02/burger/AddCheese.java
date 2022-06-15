package problem02.burger;

public class AddCheese extends BurgerDecorator{
    public AddCheese(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 20;
    }
}
