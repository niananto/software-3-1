import java.util.ArrayList;

abstract class Account { //savings, student, loan, fixed deposit
    protected int year;
    protected String name;
    protected int balance;
    protected ArrayList<Integer> deposits;
    protected ArrayList<Integer> loans;
    protected static int interestRate = 10;
    protected int maxPossibleLoan;

    Account(String name) {
        year = 0;
        this.name = name;
        balance = 0;
        deposits = new ArrayList<>();
        loans = new ArrayList<>();
    }

    boolean deposit(int amount) {
        balance += amount;
        deposits.add(amount);
        System.out.println(amount + "$ deposited; current balance " + balance + "$");
        return true;
    }
    abstract boolean withdraw(int amount);
    boolean requestLoan(int amount) {
        if (amount <= maxPossibleLoan) {
            System.out.println(amount + "$ loan requested. Waiting for approval");
            return true;
        }
        System.out.println("Invalid loan request");
        return false;
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
    int getInterestRate() {
        return interestRate;
    }
    void setInterestRate(int interest) {
        interest = interest;
    }
    int getYear() {
        return year;
    }
    void setYear(int year) {
        this.year = year;
    }
    public ArrayList<Integer> getDeposits() {
        return deposits;
    }
    public void setDeposits(ArrayList<Integer> deposits) {
        this.deposits = deposits;
    }
    public ArrayList<Integer> getLoans() {
        return loans;
    }
    public void setLoans(ArrayList<Integer> loans) {
        this.loans = loans;
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String name) {
        super(name);
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
}

class StudentAccount extends Account {
    StudentAccount(String name) {
        super(name);
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
}

class LoanAccount extends Account {
    private int initialLoan;

    LoanAccount(String name, int initialLoan) {
        super(name);

        this.initialLoan = initialLoan;
        maxPossibleLoan = initialLoan*5/100;

        loans.add(initialLoan);
        balance = -initialLoan;
    }

    @Override
    boolean withdraw(int amount) {
        System.out.println("Loan accounts can't withdraw money");
        return false;
    }

//    @Override
//    boolean deposit(int amount) {
//        // I should implement this - if someone deposits more than
//        // there standing loan amount, the account should turn to a savings one
//        balance += amount;
//        deposits.add(amount);
//        return true;
//    }
}

class FixedDepositAccount extends Account {
    FixedDepositAccount(String name) {
        super(name);
        maxPossibleLoan = 100000;
    }

    @Override
    boolean withdraw(int amount) {
        if (year >= 1 && amount <= balance) {
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
            deposits.add(amount);
            System.out.println(amount + "$ deposited; current balance " + balance + "$");
            return true;
        }
        System.out.println("A fixed deposit account must deposit an amount more than 50000$");
        return false;
    }
}
