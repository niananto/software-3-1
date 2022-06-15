package problem02.burger;

public abstract class BurgerDecorator implements Burger{
    private Burger decoratedBurger;

    BurgerDecorator(Burger newBurger) {
        decoratedBurger = newBurger;
    }

    @Override
    public int getPrice() {
        return decoratedBurger.getPrice();
    }
}
