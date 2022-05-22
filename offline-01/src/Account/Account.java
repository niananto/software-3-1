package Account;

import Bank.Bank;

import java.util.ArrayList;

public abstract class Account { //savings, student, loan, fixed deposit
    Client client;

    protected String accountType;
    protected int creationYear;
    protected String name;
    protected double balance;
    protected double loan = 0;
    protected ArrayList<Double> depositHistory;
    protected ArrayList<Double> loanHistory;
    protected double maxPossibleLoan;
    protected double loanInterestRate = 10.0;

    Account(String name, double initialBalance, int year) {
        creationYear = year;
        this.name = name;
        balance = initialBalance;
        depositHistory = new ArrayList<>();
        loanHistory = new ArrayList<>();
    }

    void deposit(double amount) {
        if (loan == 0) {
            balance += amount;
        } else {
            if (amount > loan) {
                loan = 0;
                balance += (amount - loan);
            } else {
                loan -= amount;
            }
        }
        depositHistory.add(amount);
        System.out.println(amount + "$ deposited; current balance " + balance + "$ and loan " + loan + "$");
    }

    abstract boolean withdraw(double amount);

    boolean checkLoanRequest(double amount) {
        return (amount + loan) <= maxPossibleLoan;
    }

    public void deduceServiceCharge() {
        if (balance >= 500) {
            balance -= 500;
        } else {
            balance = 0;
            loan += (500 - balance);
        }
    }

    public void addDepositInterest(double depositInterestRate) {
        balance += (balance - loan) * depositInterestRate / 100;
    }

    public void deduceLoanInterest() {
        double loanInterest = loan * loanInterestRate / 100;

//        if (loanInterest <= balance) {
//            balance -= loanInterest;
//        } else {
//            balance = 0;
//            loan += (loanInterest - balance);
//        }

        loan += loanInterest;
    }

    public void loanApproved(double amount) {
        loanHistory.add(amount);
        loan += amount;
        balance += amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }

    public double getLoan() {
        return loan;
    }
}




class SavingsAccount extends Account {
    SavingsAccount(String name, double initialBalance, int year) {
        super(name, initialBalance, year);
        accountType = "SAVINGS";
        maxPossibleLoan = 10000;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= 1000) {
            balance -= amount;
            System.out.println("Successfully withdrawn " + amount + "$. Current balance " + balance + "$");
            return true;
        }
        System.out.println("Invalid transaction. Current balance " + balance + "$");
        return false;
    }
}




class StudentAccount extends Account {
    StudentAccount(String name, double initialBalance, int year) {
        super(name, initialBalance, year);
        accountType = "STUDENT";
        maxPossibleLoan = 1000;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 10000 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn " + amount + "$. Current balance " + balance + "$");
            return true;
        }
        System.out.println("Invalid transaction. Current balance " + balance + "$");
        return false;
    }

}



class FixedDepositAccount extends Account {
    FixedDepositAccount(String name, double initialBalance, int year) {
        super(name, initialBalance, year);
        accountType = "FIXEDDEPOSIT";
        maxPossibleLoan = 100000;
    }

    @Override
    public boolean withdraw(double amount) {
        if ((Bank.getInstance().getYear() - creationYear) >= 1 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn " + amount + "$. Current balance " + balance + "$");
            return true;
        }
        System.out.println("Invalid transaction. Current balance " + balance + "$");
        return false;
    }

    @Override
    public void deposit(double amount) {
        if (amount >= 50000) {
            balance += amount;
            depositHistory.add(amount);
            System.out.println(amount + "$ deposited; current balance " + balance + "$");
        }
        System.out.println("A fixed deposit account must deposit an amount more than 50000$");
    }

}



class LoanAccount extends Account {
    private final double initialLoan;

    LoanAccount(String name, double initialLoan, int year) {
        super(name, 0, year);
        accountType = "LOAN";
        this.initialLoan = initialLoan;
        maxPossibleLoan = initialLoan + initialLoan*5/100;
        loan = initialLoan;
    }

    @Override
    public boolean withdraw(double amount) {
        System.out.println("Loan accounts can't withdraw money");
        return false;
    }

    @Override
    public void deduceServiceCharge() {
        // do nothing
    }

    @Override
    public void loanApproved(double amount) {
        loanHistory.add(amount);
        loan += amount;
    }
}
