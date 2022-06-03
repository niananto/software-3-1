package problem01.part.controller;

public class ControllerFactory {
    public Controller getController(String cName) throws Exception {
        if(cName.toLowerCase().contains("atmega")) {
            return new ATMega32();
        } else if(cName.toLowerCase().contains("arduino")) {
            return new ArduinoMega();
        } else if(cName.toLowerCase().contains("raspberry")) {
            return new RaspberryPi();
        } else {
            throw new Exception("No controller name matched");
        }
    }
}
