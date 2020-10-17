package LoginApp;

import java.io.File;
import java.util.Scanner;

public class application {

    private static Scanner scanner;

    public static void main(String[] args){
        String username = "Bob";
        String password = "002";
        String filepath = "./LoginApp/members.txt";

        if(verifyLogin(username, password, filepath)){
            System.out.println("found");
        }else{
            System.out.println("not found");
        }
    }

    public static boolean verifyLogin(String username, String password, String filepath){
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try{
            scanner = new Scanner(new File(filepath));
            scanner.useDelimiter("[,\n]");

            while(scanner.hasNext() && !found){
                tempUsername = scanner.next();
                tempPassword = scanner.next();

                if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())){
                    found = true;
                    return found;
                }
            }
            scanner.close();
            

        }catch(Exception e){
            System.out.println("Error. File not found");
        }
        return found;
    }
}