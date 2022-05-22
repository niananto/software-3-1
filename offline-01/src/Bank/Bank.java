package Bank;

import Account.Account;
import Account.AccountFactory;
import Account.Client;
import Employee.Employee;
import Employee.EmployeeFactory;

import java.util.HashMap;

public class Bank {

    private static Bank bank = null;
    public static Bank getInstance() {
        if (bank == null) bank = new Bank();
        return bank;
    }

    private int year;
    private double internalFund;
    HashMap<String, Employee> employees;
    EmployeeFactory employeeFactory;
    HashMap<String, Account> accounts;
    AccountFactory accountFactory;
    HashMap<String, Client> clients;

    HashMap<String, Double> loanRequests;
    HashMap<String, Double> interestRates;

    User activeUser;

    private Bank() {
        year = 2022;
        internalFund = 1000000;
        employees = new HashMap<>();
        employeeFactory = new EmployeeFactory();
        accounts = new HashMap<>();
        accountFactory = new AccountFactory();
        clients = new HashMap<>();

        loanRequests = new HashMap<>();
        interestRates = new HashMap<>();
        interestRates.put("SAVINGS", 10.0);
        interestRates.put("STUDENT", 5.0);
        interestRates.put("FIXEDDEPOSIT", 15.0);
        interestRates.put("LOAN", 0.0);

        System.out.print("Bank Created; ");
        Employee md = employeeFactory.getEmployee("ManagingDirector", this, "MD");
        employees.put("MD", md);
        System.out.print("MD");
        for (int i=1; i<=2; i++) {
            Employee o = employeeFactory.getEmployee("Officer", this, "O"+i);
            employees.put("O"+i, o);
            System.out.print(", O"+i);
        }
        for (int i=1; i<=5; i++) {
            Employee c = employeeFactory.getEmployee("Cashier", this, "C"+i);
            employees.put("C"+i, c);
            System.out.print(", C"+i);
        }
        System.out.println(" created");
    }

    public void login(String name) {
        if (employees.get(name) != null) {
            activeUser = employees.get(name);
            System.out.println("logged in with " + name);
        } else if (accounts.get(name) != null) {
            activeUser = accounts.get(name).getClient();
            System.out.println("logged in with " + name);
        } else {
            System.out.println("name doesn't match any user");
        }
    }

    public void logout() {
        System.out.println("Operations/Transactions for " + activeUser.getName() + " is closed");
        activeUser = null;
    }

    private boolean isLoggedin() {
        return activeUser != null;
    }

    public void query() {
        if(!isLoggedin()) {
            System.out.println("You must log in first");
            return;
        }
        activeUser.query();
    }

    public void createAccount(String accountType, String name, double initial) {
        if (accounts.get(name) != null) {
            System.out.println("Account already exists");
            return;
        }

        if (accountType.equalsIgnoreCase("LOAN")) {
            internalFund -= initial;
        } else {
            internalFund += initial;
        }
        Account account = accountFactory.getAccount(accountType, name, initial, this.year);
        accounts.put(name, account);

        Client client = new Client(account, name);
        account.setClient(client);
        clients.put(name, client);

        System.out.println(accountType + " account for " + name + " created; initial balance " + initial + "$");
        login(name);
    }

    public void deposit(double amount) {
        if(!isLoggedin()) {
            System.out.println("You must log in first");
            return;
        }

        if (activeUser.deposit(amount)) {
            internalFund += amount;
        }
    }

    public void withdraw(double amount) {
        if(!isLoggedin()) {
            System.out.println("You must log in first");
            return;
        }

        if (activeUser.withdraw(amount)) {
            internalFund -= amount;
        }
    }

    public void requestLoan(double amount) {
        if(!isLoggedin()) {
            System.out.println("You must log in first");
            return;
        }

        if (activeUser.checkLoanRequest(amount)) {
            loanRequests.put(activeUser.getName(), amount);
            System.out.println(amount + "$ loan requested. Waiting for approval");
            return;
        }

        System.out.println("Invalid loan request");
    }

    public void lookup(String name) {
        if(!isLoggedin()) {
            System.out.println("You must log in first");
            return;
        }

        activeUser.lookup(name);
    }

    public void approveLoan() {
        if(!isLoggedin()) {
            System.out.println("You must log in first");
            return;
        }

        activeUser.approveLoan();
    }

    public void changeInterestRate(String accountType, double newRate) {
        if(!isLoggedin()) {
            System.out.println("You must log in first");
            return;
        }

        activeUser.changeInterestRate(accountType, newRate);
    }

    public void seeInternalFund() {
        if(!isLoggedin()) {
            System.out.println("You must log in first");
            return;
        }

        activeUser.seeInternalFund();
    }

    public void increaseYear() {
        year++;
        accounts.forEach((name, account) -> {
            account.deduceServiceCharge();
            account.addDepositInterest(interestRates.get(account.getAccountType()));
            account.deduceLoanInterest();
        });
        System.out.println("1 year passed");
    }

    public double getInternalFund() {
        return internalFund;
    }

    public int getYear() {
        return year;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public HashMap<String, Double> getLoanRequests() {
        return loanRequests;
    }

    public HashMap<String, Double> getInterestRates() {
        return interestRates;
    }

    public void setInternalFund(double internalFund) {
        this.internalFund = internalFund;
    }
}
