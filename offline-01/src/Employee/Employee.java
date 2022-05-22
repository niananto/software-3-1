package Employee;

import Bank.Bank;
import Bank.User;

import java.util.Map;

public abstract class Employee extends User {
    Bank bank;

    Employee(Bank bank, String name) {
        this.bank = bank;
        this.name = name;
    }

    protected void lookup(String name) {
        if (bank.getAccounts().get(name) != null) {
            System.out.println(name + "'s current balance " + bank.getAccounts().get(name).getBalance() + "$ and loan "
                + bank.getAccounts().get(name).getLoan() + "$");
            return;
        }
        System.out.println("No such account");
    }

    protected void approveLoan() {
        System.out.println("Permission denied");
    }

    protected void changeInterestRate(String accountType, double newRate) {
        System.out.println("Permission denied");
    }

    protected void seeInternalFund() {
        System.out.println("Permission denied");
    }
}

abstract class CanApproveLoan extends Employee {
    CanApproveLoan(Bank bank, String name) {
        super(bank, name);
    }

    @Override
    protected void approveLoan() {
        for (Map.Entry<String, Double> set : bank.getLoanRequests().entrySet()) {
            String name = set.getKey();
            double amount = set.getValue();

            bank.getAccounts().get(name).loanApproved(amount);
            System.out.println("Loan for " + name + " approved");
            bank.getLoanRequests().remove(name);

            if (bank.getAccounts().get(name).getAccountType().equalsIgnoreCase("LOAN")) {
                bank.setInternalFund(bank.getInternalFund() - amount);
            }
        }
    }
}

class ManagingDirector extends  CanApproveLoan {
    public ManagingDirector(Bank bank, String name) {
        super(bank, name);
    }

    @Override
    protected void changeInterestRate(String accountType, double newRate) {
        bank.getInterestRates().replace(accountType.toUpperCase(), newRate);
    }

    @Override
    protected void seeInternalFund() {
        System.out.println("Internal Fund " + bank.getInternalFund() + "$");
    }
}

class Officer extends CanApproveLoan {
    public Officer(Bank bank, String name) {
        super(bank, name);
    }
}

class Cashier extends Employee {

    public Cashier(Bank bank, String name) {
        super(bank, name);
    }
}
