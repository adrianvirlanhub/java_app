package BankingApp;

import java.util.Scanner;

public class BankAccount {
    
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    BankAccount(String customerName, String customerID){
        this.customerName = customerName;
        this.customerID = customerID;
    }

    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }
        else{
            System.out.println("No transaction occured!");
        }
    }
    
    void showMenu(){
        int userOption = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to this ATM " + customerName);
        System.out.println("Your ID is " + customerID);
        System.out.print('\n');
        System.out.println("1. Check account balance");
        System.out.println("2. Deposit into account");
        System.out.println("3. Withdraw from account");
        System.out.println("4. See previous transaction");
        System.out.println("5. Exit");

        do{
            System.out.println("------------------------------");
            System.out.println("---Please enter your option---");
            System.out.println("------------------------------");
            userOption = scanner.nextInt();
            System.out.println("\n");

            switch(userOption){
                case 1:
                    System.out.println("Balance = " + balance);
                    System.out.println("\n");
                    break;
                    
                case 2:
                    System.out.println("How much you would like to deposit?");
                    System.out.print("Amount = ");
                    int depositedAmount = scanner.nextInt();
                    if(depositedAmount < 0){
                        System.out.print("Please enter a valid amount!");
                    }
                    else if(depositedAmount == 0){
                        System.out.print("Adding 0 funds... It won't take much");
                    }
                    else{
                        deposit(depositedAmount);
                    }
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("How much you would like to withdraw?");
                    System.out.print("Amount = ");
                    int withdrawnAmount = scanner.nextInt();
                    if(withdrawnAmount > balance){
                        System.out.print("Not enough funds!");
                    }
                    else{
                        withdraw(withdrawnAmount);
                    }
                    System.out.println("\n");
                    break;
                    
                case 4:
                    System.out.println("--Processing--");
                    getPreviousTransaction();
                    System.out.println("\n");
                    break;
                
                case 5:
                    System.out.println("---Exiting...---");
                    break;

                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }while(userOption != 5);
        scanner.close();
    }
}