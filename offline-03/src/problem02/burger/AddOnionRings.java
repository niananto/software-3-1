package problem02.burger;

public class AddOnionRings extends BurgerDecorator{
    public AddOnionRings(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 45;
    }
}
