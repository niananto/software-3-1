abstract class Employee {
    protected int lookup(Account account) {
        return account.getBalance();
    }
}

class ManagingDirector extends Employee {
    // approve loan
    // change interest rate
    // see internal fund
    int seeInternalFund() {
        return Bank.getInstance().getInternalFund();
    }
}

class Officer extends Employee {
    // approve loan
}

class Cashier extends Employee {

}
