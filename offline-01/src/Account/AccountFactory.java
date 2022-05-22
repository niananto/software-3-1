package Account;

public class AccountFactory {
    public Account getAccount(String accountType, String name, double initial, int year) {
        if (accountType == null) {
            return null;
        }

        if (accountType.toLowerCase().contains("saving")) {
            return new SavingsAccount(name, initial, year);
        } else if (accountType.toLowerCase().contains("student")) {
            return new StudentAccount(name, initial, year);
        } else if (accountType.toLowerCase().contains("loan")) {
            return new LoanAccount(name, initial, year);
        } else if (accountType.toLowerCase().contains("fixed")) {
            if (initial < 100000) {
                System.out.println("Fixed Deposit accounts require at least 100000");
                return null;
            }
            return new FixedDepositAccount(name, initial, year);
        } else {
            return null;
        }
    }
}
