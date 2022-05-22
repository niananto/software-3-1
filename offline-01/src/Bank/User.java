package Bank;

import Account.Account;

public class User {

    protected String name;

    protected void query() {
        System.out.println("Invalid Operation");
    }

    protected boolean deposit(double amount) {
        System.out.println("Invalid Operation");
        return false;
    }

    protected boolean withdraw(double amount) {
        System.out.println("Invalid Operation");
        return false;
    }

    protected boolean checkLoanRequest(double amount) {
        System.out.println("Invalid Operation");
        return false;
    }

    protected void lookup(String name) {
        System.out.println("Invalid Operation");
    }

    protected void approveLoan() {
        System.out.println("Invalid Operation");
    }

    protected void changeInterestRate(String accountType, double newRate) {
        System.out.println("Invalid Operation");
    }

    protected void seeInternalFund() {
        System.out.println("Invalid Operation");
    }

    public String getName() {
        return name;
    }
}


