package Bank;

import java.util.ArrayList;

abstract class Account { //savings, student, loan, fixed deposit
    protected int creationYear;
    protected String name;
    protected int balance;
    protected int loan;
    protected ArrayList<Integer> depositHistory;
    protected ArrayList<Integer> loanHistory;
    protected int maxPossibleLoan;

    Account(String name, int initialBalance, int year) {
        creationYear = year;
        this.name = name;
        balance = initialBalance;
        loan = 0;
        depositHistory = new ArrayList<>();
        loanHistory = new ArrayList<>();
    }

    boolean deposit(int amount) {
        balance += amount;
        depositHistory.add(amount);
        System.out.println(amount + "$ deposited; current balance " + balance + "$");
        return true;
    }

    abstract boolean withdraw(int amount);

    boolean checkLoanRequest(int amount) {
        if ((amount + loan) <= maxPossibleLoan) {
            return true;
        }
        return false;
    }

    abstract int calculateInterest();

    abstract void addInterest();

    void loanApproved(int amount) {
        loanHistory.add(amount);
        loan += amount;
        balance += amount;
    }

    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    int getBalance() {
        return balance;
    }
    void setBalance(int balance) {
        this.balance = balance;
    }
    int getCreationYear() {
        return creationYear;
    }
    void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }
    ArrayList<Integer> getDepositHistory() {
        return depositHistory;
    }
    void setDepositHistory(ArrayList<Integer> depositHistory) {
        this.depositHistory = depositHistory;
    }
    int getLoan() {
        return loan;
    }
    void setLoan(int loan) {
        this.loan = loan;
    }
    ArrayList<Integer> getLoanHistory() {
        return loanHistory;
    }
    void setLoanHistory(ArrayList<Integer> loanHistory) {
        this.loanHistory = loanHistory;
    }
    int getMaxPossibleLoan() {
        return maxPossibleLoan;
    }
    void setMaxPossibleLoan(int maxPossibleLoan) {
        this.maxPossibleLoan = maxPossibleLoan;
    }
}

class SavingsAccount extends Account {
    static int interestRate = 10;

    SavingsAccount(String name, int initialBalance, int year) {
        super(name, initialBalance, year);
        maxPossibleLoan = 10000;
    }

    @Override
    boolean withdraw(int amount) {
        if (balance - amount >= 1000) {
            balance -= amount;
            System.out.println("Successfully withdrawn " + amount + "$. Current balance " + balance + "$");
            return true;
        }
        System.out.println("Invalid transaction. Current balance " + balance + "$");
        return false;
    }

    @Override
    int calculateInterest() {
        return balance*interestRate/100;
    }

    @Override
    void addInterest() {
        balance += balance*interestRate/100;
    }
}

class StudentAccount extends Account {
    static int interestRate = 10;

    StudentAccount(String name, int initialBalance, int year) {
        super(name, initialBalance, year);
        maxPossibleLoan = 1000;
    }

    @Override
    boolean withdraw(int amount) {
        if (amount <= 10000 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn " + amount + "$. Current balance " + balance + "$");
            return true;
        }
        System.out.println("Invalid transaction. Current balance " + balance + "$");
        return false;
    }

    @Override
    int calculateInterest() {
        return balance*interestRate/100;
    }

    @Override
    void addInterest() {
        balance += balance*interestRate/100;
    }
}

class LoanAccount extends Account {
    static int interestRate = 10;
    private int initialLoan;

    LoanAccount(String name, int initialLoan, int year) {
        super(name, 0, year);
        this.initialLoan = initialLoan;
        maxPossibleLoan = initialLoan*5/100;
    }

    @Override
    boolean withdraw(int amount) {
        System.out.println("Loan accounts can't withdraw money");
        return false;
    }

    @Override
    boolean deposit(int amount) {
        if (amount <= loan) {
            loan -= amount;
            depositHistory.add(amount);
            System.out.println(amount + "$ deposited; existing loan " + loan + "$; balance " + balance + "$");

            return true;
        }
        balance = (amount - loan);
        loan = 0;
        depositHistory.add(amount);
        System.out.println(amount + "$ deposited; existing loan " + loan + "$; balance " + balance + "$");
        return true;
    }

    @Override
    int calculateInterest() {
//        return initialLoan*interestRate/100;
        return loan*interestRate/100;
    }

    @Override
    void addInterest() {
//        loan += initialLoan*interestRate/100;
        loan += loan*interestRate/100;
    }
}

class FixedDepositAccount extends Account {
    static int interestRate = 10;

    FixedDepositAccount(String name, int initialBalance, int year) {
        super(name, initialBalance, year);
        maxPossibleLoan = 100000;
    }

    @Override
    boolean withdraw(int amount) {
        if ((Bank.getInstance().getYear() - creationYear) >= 1 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn " + amount + "$. Current balance " + balance + "$");
            return true;
        }
        System.out.println("Invalid transaction. Current balance " + balance + "$");
        return false;
    }

    @Override
    boolean deposit(int amount) {
        if (amount >= 50000) {
            balance += amount;
            depositHistory.add(amount);
            System.out.println(amount + "$ deposited; current balance " + balance + "$");
            return true;
        }
        System.out.println("A fixed deposit account must deposit an amount more than 50000$");
        return false;
    }

    @Override
    int calculateInterest() {
        return balance*interestRate/100;
    }

    @Override
    void addInterest() {
        balance += balance*interestRate/100;
    }
}
