package problem02idea02;

class ConcreteFontFactory implements IFontFactory{
    @Override
    public Font getFont(String font) throws Exception {
        if(font.equalsIgnoreCase("couriernew")) {
            return new CourierNew();
        } else if(font.equalsIgnoreCase("monaco")) {
            return new Monaco();
        } else if(font.equalsIgnoreCase("consolas")) {
            return new Consolas();
        } else {
            throw new Exception("not a supported font");
        }
    }
}
