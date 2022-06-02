package problem02idea03;

public class EnvironmentFactory {
//    c + courier new
//    cpp + monaco
//    py + consolas

    public Environment getEnvironment(String lang) throws Exception {
        if(lang.equalsIgnoreCase("c")) {
            return new CEnvironment(new CourierNew());
        } else if(lang.equalsIgnoreCase("cpp")) {
            return new CppEnvironment(new Monaco());
        } else if(lang.equalsIgnoreCase("py")) {
            return new PyEnvironment(new Consolas());
        } else {
            throw new Exception("not a supported environment");
        }
    }
}
