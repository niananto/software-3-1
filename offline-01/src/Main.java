import Bank.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        Scanner sc = new Scanner(System.in);

        while(true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("exit")) break;

            String[] inputs = line.split(" ");
            if (inputs[0].equalsIgnoreCase("create")) {
                bank.createAccount(inputs[2], inputs[1], Integer.parseInt(inputs[3]));

            } else if (inputs[0].equalsIgnoreCase("open")) {
                bank.login(inputs[1]);

            } else if (inputs[0].equalsIgnoreCase("close")) {
                bank.logout();

            } else if (inputs[0].equalsIgnoreCase("query")) {
                bank.query();

            } else if (inputs[0].equalsIgnoreCase("deposit")) {
                bank.deposit(Integer.parseInt(inputs[1]));

            } else if (inputs[0].equalsIgnoreCase("withdraw")) {
                bank.withdraw(Integer.parseInt(inputs[1]));

            } else if (inputs[0].equalsIgnoreCase("request")) {
                bank.requestLoan(Integer.parseInt(inputs[1]));

            } else if (inputs[0].equalsIgnoreCase("lookup")) {
                bank.lookup(inputs[1]);

            } else if (inputs[0].equalsIgnoreCase("approve")) {
                bank.approveLoan();

            } else if (inputs[0].equalsIgnoreCase("change")) {
                bank.changeInterestRate(inputs[1], Double.parseDouble(inputs[2]));

            } else if (inputs[0].equalsIgnoreCase("see")) {
                bank.seeInternalFund();

            } else if (inputs[0].equalsIgnoreCase("inc")) {
                bank.increaseYear();
            }
        }
    }
}

//Create Alice Student 1000
//Deposit 20000
//Withdraw 12000
//Query
//Request 500
//Close
//Open O1
//Approve Loan
//Change Student 7.5
//Lookup Alice
//See
//Close
//Open Alice
//Query
//Close
//INC
//Open Alice
//Query
//Close




//
//    Create Alice Loan 100000
//        Deposit 20000
//        Withdraw 6000
//        Query
//        Request 500
//        Close
//        Open MD
//        Approve Loan
//        Change Student 7.50
//        Lookup Alice
//        See
//        Close
//        Open Alice
//        Query
//        Close
//        INC
//        Open Alice
//        Query
//        Close
//        EXIT