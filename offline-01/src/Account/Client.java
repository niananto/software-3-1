package Account;

import Account.Account;
import Bank.User;

public class Client extends User {
    Account account;

    public Client(Account account, String name) {
        this.account = account;
        this.name = name;
    }

    @Override
    protected void query() {
        System.out.println("Current balance " + account.getBalance() + "$ and loan " + account.getLoan() + "$");
    }

    @Override
    protected boolean deposit(double amount) {
        account.deposit(amount);
        return true;
    }

    @Override
    protected boolean withdraw(double amount) {
        account.withdraw(amount);
        return true;
    }

    @Override
    protected boolean checkLoanRequest(double amount) {
        return account.checkLoanRequest(amount);
    }
}
