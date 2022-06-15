package problem02.burger;

public class AddWater extends BurgerDecorator{
    public AddWater(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 25;
    }
}
