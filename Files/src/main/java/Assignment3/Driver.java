package Assignment3;

import java.util.Scanner;

public class Driver {
    public static void main(String [] ar){

        consoleATM ca=new consoleATM();
        Scanner sc=new Scanner(System.in);
        boolean looping=true;
        while(looping) {
            System.out.println("Welcome to the Simple Console ATM!\n" +
                    "Please select an option:\n" +
                    "1. Check Balance\n" +
                    "2. Deposit Funds\n" +
                    "3. Withdraw Funds\n" +
                    "4. Exit\n");
            int choice=sc.nextInt();
            int amount;
            switch(choice){
                case 1 -> System.out.println("Your balance is "+ca.Balance+"bdt\n");
                case 2 -> {
                    System.out.println("Enter amount");
                    amount = sc.nextInt();
                    ca.Deposit(amount);
                }
                case 3 -> {
                    System.out.println("Enter amount");
                    amount = sc.nextInt();
                    switch (ca.Withdraw(amount)){
                        case 1 -> System.out.println("Withdrawal Successful\n");
                        case 0 -> System.err.println("Max limit = 100 bdt\n");
                        case-1 -> System.err.println("Insufficient balance\n");
                    }
                }
                case 4 -> {
                    looping=false;
                }
                default -> System.out.println("Invalid Choice\n");
            }
        }
        sc.close();
        System.out.println("Thank you for using the ATM! Goodbye,");
    }
}
