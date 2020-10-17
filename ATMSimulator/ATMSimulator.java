package ATMSimulator;

import java.io.File;
import java.util.Scanner;

public class ATMSimulator {
    
    public static void main(String[] args){
        String filepath = "./ATMSimulator/users.txt";
        String userInputPassword = "";
        String userInputID = "";

        String userName = "";
        int userbalance = 0;

        String tempID = "";
        String tempPassword = "";
        boolean found = false;  

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter your ID and password");

        
            do{
                System.out.print("ID:");
                userInputID = scanner.next();
        
                System.out.print("Password:");
                userInputPassword = scanner.next();

                try{
                    Scanner fileScanner = new Scanner(new File(filepath));
                    fileScanner.useDelimiter("[,\n]");

                    while(fileScanner.hasNext() && !found){
                        tempID = fileScanner.next();
                        tempPassword = fileScanner.next();
    
                        if(tempID.trim().equals(userInputID.trim()) && tempPassword.trim().equals(userInputPassword.trim())){
                            found = true;
                            userName = fileScanner.next();
                            userbalance = fileScanner.nextInt();
                        }
                        
                    }
                    fileScanner.close();
                }catch(Exception e){
                    System.out.println("Error. File not found");
                }

                if(found){
                    BankAccount object1 = new BankAccount(userInputID, userName, userbalance);
                    object1.showMenu();
                }else{
                    System.out.println("Credentials wrong. Login unsuccessful. Try again");
                }

            }while(!found);
            scanner.close();
    }
}