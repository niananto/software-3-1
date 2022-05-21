package Bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    final private int numberOfOfficer = 2;
    final private int numberOfCashier = 5;

    private int year;
    private int internalFund;
    HashMap<String, Employee> employees;
    EmployeeFactory employeeFactory;
    HashMap<String, Account> accounts;
    AccountFactory accountFactory;
    HashMap<String, Integer> loanRequests;

    private Bank() {
        year = 2022;
        internalFund = 1000000;
        employees = new HashMap<>();
        employeeFactory = new EmployeeFactory();
        accounts = new HashMap<>();
        accountFactory = new AccountFactory();
        loanRequests = new HashMap<>();

        System.out.print("Bank Created; ");
        Employee md = employeeFactory.getEmployee("ManagingDirector");
        employees.put("MD", md);
        System.out.print("MD");
        for (int i=1; i<=numberOfOfficer; i++) {
            Employee o = employeeFactory.getEmployee("Officer");
            employees.put("O"+i, o);
            System.out.print(", O"+i);
        }
        for (int i=1; i<=numberOfCashier; i++) {
            Employee c = employeeFactory.getEmployee("Cashier");
            employees.put("C"+i, c);
            System.out.print(", C"+i);
        }
        System.out.println(" created");
    }

    private static Bank bank = null;
    public static Bank getInstance() {
        if (bank == null) bank = new Bank();
        return bank;
    }

    public void increaseYear() {
        year++;
        accounts.forEach((name, account) -> {
            int interest = account.calculateInterest();
            if (interest <= internalFund) {
                internalFund -= interest;
                account.addInterest();
            } else {
                System.out.println("Couldn't add interest to account " + name + " due to insufficient bank fund");
            }
        });
    }

    public boolean searchAccount(String name) {
        return accounts.get(name) != null;
    }

    public Account createAccount(String accountType, String name, int initial) {
        Account account = accountFactory.getAccount(accountType, name, initial, this.year);
        accounts.put(name, account);

        return account;
    }

    boolean deposit(String name, int amount) {
        return accounts.get(name).deposit(amount);
    }

    boolean withdraw(String name, int amount) {
        return accounts.get(name).withdraw(amount);
    }

    boolean requestLoan(String name, int amount) {
        if (accounts.get(name).checkLoanRequest(amount)) {
            loanRequests.put(name,amount);
            System.out.println(amount + "$ loan requested. Waiting for approval");

            return true;
        }

        System.out.println("Invalid loan request");
        return false;
    }

    public boolean searchEmployee(String name) {
        return employees.get(name) != null;
    }

    private Employee getEmployee(String name) {
        return employees.get(name);
    }

    int lookup(String eName, String accName) {
        return getEmployee(eName).lookup(accounts.get(accName));
    }

    void approveLoan(String eName) {
        if (getEmployee(eName).checkLoanApprovalPermission()) {
            for (Map.Entry<String, Integer> set : loanRequests.entrySet()) {
                String name = set.getKey();
                int amount = set.getValue();

                if (internalFund >= amount) {
                    accounts.get(name).loanApproved(amount);

                    internalFund -= amount;
                    System.out.println("Loan for " + name + " approved");
                    loanRequests.remove(name);
                } else {
                    System.out.println("Couldn't approve loan for " + name + ", because of insufficient bank fund");
                }

            }
        } else {
            System.out.println("You don’t have permission for this operation");
        }

    }

    void changeInterestRate(String eName, String accountType, int newRate) {
        if (getEmployee(eName).checkChangeInterestRatesPermission()) {
            accountFactory.changeInterestRate(accountType, newRate);
        } else {
            System.out.println("You don’t have permission for this operation");
        }
    }

    void seeInternalFund(String eName) {
        if (getEmployee(eName).checkSeeInternalFundPermission()) {
            System.out.println("Internal Fund : " + internalFund);
        } else {
            System.out.println("You don’t have permission for this operation");
        }
    }

    int getInternalFund() {
        return internalFund;
    }
    void setInternalFund(int internalFund) {
        this.internalFund = internalFund;
    }

    int getYear() {
        return year;
    }
}
