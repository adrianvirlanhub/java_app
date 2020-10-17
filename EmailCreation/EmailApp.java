package EmailCreation;

import java.util.Scanner;

public class EmailApp {

        public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("First Name is: ");
        String firstName = scanner.next();
        System.out.print("\nLast Name is: ");
        String lastName = scanner.next();

        Email em1 = new Email(firstName,lastName);
        System.out.println(em1.showInfo());

        scanner.close();

    }
}
