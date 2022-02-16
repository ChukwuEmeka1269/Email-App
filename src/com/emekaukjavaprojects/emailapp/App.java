package com.emekaukjavaprojects.emailapp;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        operate();
    }

    private static void operate(){
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Second Name: ");
        String lastName = scanner.nextLine();
        Email email1 = new Email(firstName, lastName, 10);
        int option ;
        do{
            System.out.println("Please select: \n"
                    + "0 - Exit\n"
                    + "1 - Show info\n"
                    + "2 - Change password\n"
                    + "3 - Set Mail Capacity\n"
                    + "4 - Set Alternative email\n"
                    + "5 - Store file\n"
                    + "6 - Read file\n");
             option = scanner.nextInt();
            switch(option){
                case 0 :
                    System.out.println("Thanks for using our App. Bye :)");
                    break;
                case 1:
                    email1.displayInfo();
                    break;
                case 2:
                    email1.changePassword();
                    break;
                case 3:
                    email1.setMailCapacity();
                    break;
                case 4:
                    email1.setAlternateEmail();
                    break;
                case 5:
                    email1.storeFile();
                    break;
                case 6:
                    email1.readFile();
                    break;
                default:
                    System.out.println("Invalid selection. Press 1 to view options.");
            }
        }while(option != 0);

    }
}
