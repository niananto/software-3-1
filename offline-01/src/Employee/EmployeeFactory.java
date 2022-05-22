package Employee;

import Bank.Bank;

public class EmployeeFactory {
    public Employee getEmployee(String employeeType, Bank bank, String name) {
        if (employeeType == null) {
            return null;
        }

        if (employeeType.equalsIgnoreCase("ManagingDirector")) {
            return new ManagingDirector(bank, name);
        } else if (employeeType.equalsIgnoreCase("Officer")) {
            return new Officer(bank, name);
        } else if (employeeType.equalsIgnoreCase("Cashier")) {
            return new Cashier(bank, name);
        } else {
            return null;
        }
    }
}
