package Bank;

import java.util.Locale;

class AccountFactory {
    Account getAccount(String accountType, String name, int initial, int year) {
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
            if (initial < 50000) {
                System.out.println("Fixed Deposit accounts require at least 50000$");
                return null;
            }
            return new FixedDepositAccount(name, initial, year);
        } else {
            return null;
        }
    }

    void changeInterestRate(String accountType, int newRate) {
        if (accountType.toLowerCase().contains("saving")) {
            SavingsAccount.interestRate = newRate;
        } else if (accountType.toLowerCase().contains("student")) {
            StudentAccount.interestRate = newRate;
        } else if (accountType.toLowerCase().contains("loan")) {
            LoanAccount.interestRate = newRate;
        } else if (accountType.toLowerCase().contains("fixed")) {
            FixedDepositAccount.interestRate = newRate;
        }

        System.out.println("Changed interest rate for " + accountType + " to " + newRate);
    }
}
