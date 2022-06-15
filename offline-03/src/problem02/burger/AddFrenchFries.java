package problem02.burger;

public class AddFrenchFries extends BurgerDecorator{
    public AddFrenchFries(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 55;
    }
}
