package BankingApp;
import java.util.Scanner;

public class ATMSimulator {
    
    public static void main(String[] args) {
        String userOption;
        String userInputName;
        String userInputID;

        Scanner scanner = new Scanner(System.in);
             
        System.out.println("Would you like to create a new bank account? Yes/No");
        userOption = scanner.next();
        System.out.println(userOption);
        if("Yes".equals(userOption)){
            System.out.println("What is your name?");
            userInputName = scanner.next();
            System.out.println("What is your ID number?");
            userInputID = scanner.next();

            BankAccount object1 = new BankAccount(userInputName, userInputID);
            object1.showMenu();
        }
        else if("No".equals(userOption)){
            System.out.println("To verify your credentials please enter your name:");
            
        }
        else{
            System.out.println("Not a valid option!");
        }
        scanner.close();
    }
    
}