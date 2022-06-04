package problem02;

class Monaco implements Font{
    @Override
    public String getNameOfFont() {
        return this.getClass().getName();
    }

    @Override
    public String toString() {
        return "Monaco";
    }
}
