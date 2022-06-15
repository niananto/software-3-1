package problem02.burger;

public class AddCoke extends BurgerDecorator{
    public AddCoke(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 35;
    }
}
