package Bank;

class EmployeeFactory {
    Employee getEmployee(String employeeType) {
        if (employeeType == null) {
            return null;
        }

        if (employeeType.equalsIgnoreCase("ManagingDirector")) {
            return new ManagingDirector();
        } else if (employeeType.equalsIgnoreCase("Officer")) {
            return new Officer();
        } else if (employeeType.equalsIgnoreCase("Cashier")) {
            return new Cashier();
        } else {
            return null;
        }
    }
}
