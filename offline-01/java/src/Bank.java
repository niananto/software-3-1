import java.util.HashMap;

class Bank { // singleton
    private int internalFund;
    ManagingDirector md;
    Officer[] officers;
    Cashier[] cashiers;
    HashMap<String, Account> accounts;

    private Bank() {
        internalFund = 1000000;
        md = new ManagingDirector();
        officers = new Officer[2];
        cashiers = new Cashier[5];
        accounts = new HashMap<>();
    }

    private static Bank bank = null;
    static Bank getInstance() {
        if (bank == null) bank = new Bank();
        return bank;
    }

    boolean increaseYear() {
        accounts.forEach((name, account) -> {
            account.setYear(account.getYear()+1);;
            int depositOrLoan = account.getBalance();
            int interestRate = account.getInterestRate();
            if (account.getClass().getName().contains("Loan")) {
                // no change in internal fund
                depositOrLoan += depositOrLoan*interestRate/100;
            } else {
                // increase in internal fund
                int interest = depositOrLoan*interestRate/100;
                depositOrLoan -= interest;
                internalFund += interest;
            }
            account.setBalance(depositOrLoan);
        });

        return true;
    }

    int getInternalFund() {
        return internalFund;
    }
    void setInternalFund(int internalFund) {
        this.internalFund = internalFund;
    }
}
