package SchoolManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class mainapp {

    public static void main(String[] args) {

        Teacher Floricau = new Teacher(1, "Floricau", 500);
        Student Angi = new Student(1, "Angi", 8);

        ArrayList<Teacher> teacherList = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();

        teacherList.add(Floricau);
        studentList.add(Angi);

        School poli = new School(teacherList, studentList);

        int userOption = 0;
        String userOptionName = " ";
        int userOptionMoney = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        do {
            System.out.print("***************************************" + "\n Welcome to the School managing system"
                    + "\n***************************************"
                    + "\nTake a look and choose an option from the ones below:" + "\n1. Check school funds"
                    + "\n2. Check a professor salary" + "\n3. Make a payment towards a professor"
                    + "\n4. Check a student payed fees" + "\n5. Student payed a part of his fees"
                    + "\n6. Add or remove a professor" + "\n7. Add or remove a student" + "\n8. Exit\n"
                    + "\nYour option is:");

            userOption = scanner.nextInt();

            switch (userOption) {
                case 1: {
                    System.out.println("\nSchool funds are: " + poli.getTotalMoneyEarned() + "\n");
                    break;
                }
                case 2: {
                    System.out.println("\nWhich professor you would like to check salary of?");

                    for (Teacher i : teacherList) {
                        System.out.print(i.getName() + " ");
                    }

                    System.out.print("\nType in the name:");
                    userOptionName = scanner2.nextLine();

                    for (Teacher j : teacherList) {
                        if (j.getName().equals(userOptionName)) {
                            System.out.println("\n" + j.getName() + " has a salary of $" + j.getSalary()
                                    + " and he earned $" + j.getSalaryEarned() + "\n");
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("\nWhich professor do you want to make a payment towards?");

                    for (Teacher i : teacherList) {
                        System.out.print(i.getName() + " ");
                    }

                    System.out.print("\n" + "Type in the name:");
                    userOptionName = scanner2.nextLine();
                    System.out.print("\nAmmount of money:");
                    userOptionMoney = scanner.nextInt();

                    if (poli.getTotalMoneyEarned() > userOptionMoney) {
                        for (Teacher j : teacherList) {
                            if (j.getName().equals(userOptionName)) {
                                j.receiveSalary(userOptionMoney);
                                System.out.println("\n" + j.getName() + " earned $" + j.getSalaryEarned());
                            } else {
                                System.out.println("Not a teacher!");
                            }
                        }
                    } else {
                        System.out.println("Not enough funds!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("\nWhich student you would like to check paid fees of?");

                    for (Student i : studentList) {
                        System.out.print(i.getName() + " ");
                    }

                    System.out.print("\nType in the name:");
                    userOptionName = scanner2.nextLine();

                    for (Student j : studentList) {
                        if (j.getName().equals(userOptionName)) {
                            System.out.println("\n" + j.getName() + " has paid $" + j.getFeesPaid()
                                    + " out of a total $" + j.getFeesTotal() + "\n");
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Which student made a payment?");

                    for (Student i : studentList) {
                        System.out.print(i.getName() + " ");
                    }

                    System.out.print("\nType in the name:");
                    userOptionName = scanner2.nextLine();
                    System.out.print("\nAmmount of money:");
                    userOptionMoney = scanner.nextInt();

                    if (userOptionMoney >= 0) {
                        for (Student j : studentList) {
                            if (j.getName().equals(userOptionName)) {
                                j.setFeesPaid(userOptionMoney);
                                System.out.println("\n" + j.getName() + " payed $" + j.getFeesPaid() + " and has $"
                                        + j.getRemainingFees() + " fees remaining\n");
                            } else {
                                System.out.println("Not a student!");
                            }
                        }
                    } else {
                        System.out.println("Negative number not allowed!");
                    }
                    break;
                }
                case 6: {
                    System.out.println("You want to Add or Delete a professor");
                    userOptionName = scanner2.nextLine();
                    if ("Add".equals(userOptionName)) {
                        System.out.print("Give an id:");
                        userOption = scanner.nextInt();
                        System.out.print("Give a name:");
                        userOptionName = scanner2.nextLine();
                        System.out.print("Give a salary:");
                        userOptionMoney = scanner.nextInt();
                        teacherList.add(new Teacher(userOption, userOptionName, userOptionMoney));
                    } else if ("Delete".equals(userOptionName)) {
                        System.out.println("Which one you want to remove?");

                        for (Teacher i : teacherList) {
                            System.out.print(i.getName() + " ");
                        }

                        System.out.print("\n" + "Type in the name:");
                        userOptionName = scanner2.nextLine();

                        for (Iterator<Teacher> iterator = teacherList.iterator(); iterator.hasNext();) {
                            Teacher value = iterator.next();
                            if (value.getName().equals(userOptionName)) {
                                iterator.remove();
                            }
                        }
                    } else {
                        System.out.println("Not a valid option!");
                    }
                    break;
                }
                case 7: {
                    System.out.println("You want to Add or Delete a student");
                    userOptionName = scanner2.nextLine();
                    if ("Add".equals(userOptionName)) {
                        System.out.print("Give an id:");
                        userOption = scanner.nextInt();
                        System.out.print("Give a name:");
                        userOptionName = scanner2.nextLine();
                        System.out.print("Give a grade:");
                        userOptionMoney = scanner.nextInt();
                        studentList.add(new Student(userOption, userOptionName, userOptionMoney));
                    } else if ("Delete".equals(userOptionName)) {
                        System.out.println("Which one you want to remove?");

                        for (Student i : studentList) {
                            System.out.print(i.getName() + " ");
                        }

                        System.out.print("\n" + "Type in the name:");
                        userOptionName = scanner2.nextLine();

                        for (Iterator<Student> iterator = studentList.iterator(); iterator.hasNext();) {
                            Student value = iterator.next();
                            if (value.getName().equals(userOptionName)) {
                                iterator.remove();
                            }
                        }
                    } else {
                        System.out.println("Not a valid option!");
                    }
                    break;
                }
                default: {
                    System.out.println("Not a valid option!");
                    break;
                }
            }
        } while (userOption != 8);
        scanner.close();
        scanner2.close();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

