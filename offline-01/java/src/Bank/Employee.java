package Bank;

abstract class Employee {
    protected int lookup(Account account) {
        return account.getBalance();
    }

    protected boolean checkLoanApprovalPermission() {
        return false;
    }

    protected boolean checkChangeInterestRatesPermission() {
        return false;
    }

    protected boolean checkSeeInternalFundPermission() {
        return false;
    }
}

class ManagingDirector extends Employee {
    @Override
    protected boolean checkLoanApprovalPermission() {
        return true;
    }

    @Override
    protected boolean checkChangeInterestRatesPermission() {
        return true;
    }

    @Override
    protected boolean checkSeeInternalFundPermission() {
        return true;
    }
}

class Officer extends Employee {
    @Override
    protected boolean checkLoanApprovalPermission() {
        return true;
    }
}

class Cashier extends Employee {

}
