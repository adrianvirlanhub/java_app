package EmailCreation;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private String alternateEmail;
    private String companySuffix = "techcompany.com";
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;

    //Constructor will receive firstName and lastName
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department and return it
        this.department = setDepartment();

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    //Ask for department
    private String setDepartment(){
        System.out.print("Departmen Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();
        scanner.close();
        switch(departmentChoice){
            case 1:{
                return "Sales";
            }
            case 2:{
                return "Development";
            }
            case 3:{
                return "Accounting";
            }
            case 0:{
                return "";
            }
            default:{
                return "Not a valid entry";
            }
        }
    }
    
    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    //Set the mailbox capaciy
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Setthe alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    //Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName + "\n" +
                "Company Name " + email + "\n" +
                "Mailbox Capacity: " + mailboxCapacity + "mb";
    }
}