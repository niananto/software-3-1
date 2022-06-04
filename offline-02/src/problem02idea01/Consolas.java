package problem02idea01;

class Consolas implements Font{
    @Override
    public String getNameOfFont() {
        return this.getClass().getName();
    }

    @Override
    public String toString() {
        return "Consolas";
    }
}
