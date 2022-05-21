import Bank.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        Scanner sc = new Scanner(System.in);
        String[] activeUser = new String[2];
        int userType = -1;

        while(true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("exit")) break;

            String[] inputs = line.split(" ");
            if (inputs[0].equalsIgnoreCase("create")) {
                bank.createAccount(inputs[2], inputs[1], Integer.parseInt(inputs[3]));

            } else if (inputs[0].equalsIgnoreCase("open")) {
                if (bank.searchEmployee(inputs[1])) {
                    userType = 0;
                    activeUser[0] = inputs[1];
                } else if (bank.searchAccount(inputs[1])) {
                    userType = 1;
                    activeUser[1] = inputs[1];
                }

            } else if (inputs[0].equalsIgnoreCase("close")) {
                System.out.println("Operations/Transactions for " + activeUser[userType] + " is closed");
                userType = -1;
            } else if (inputs[0].equalsIgnoreCase("query")) {
                if (userType == 1) {

                }
            } else if (inputs[0].equalsIgnoreCase("deposit")) {

            } else if (inputs[0].equalsIgnoreCase("withdraw")) {

            } else if (inputs[0].equalsIgnoreCase("request")) {

            } else if (inputs[0].equalsIgnoreCase("lookup")) {

            } else if (inputs[0].equalsIgnoreCase("approve")) {

            } else if (inputs[0].equalsIgnoreCase("change")) {

            } else if (inputs[0].equalsIgnoreCase("see")) {

            } else if (inputs[0].equalsIgnoreCase("inc")) {
                bank.increaseYear();
            }
        }
    }
}
