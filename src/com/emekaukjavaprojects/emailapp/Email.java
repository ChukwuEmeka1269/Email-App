package com.emekaukjavaprojects.emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Email {


    public static Scanner scanner = new Scanner(System.in);

    private String firstName;
    private String lastName;

    private String email;
    private String password;
    private int mailCapacity=500;
    private String alternativeMail;

    private String department;

    public Email(String firstName, String lastName, int passwordLength) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee: " + this.firstName+" "+this.lastName);
        this.password = this.generatePassword(passwordLength);
        this.department = this.setDept();
        this.email = this.generateEmail();
    }

    private String generateEmail(){
        return this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@"+this.department.toLowerCase()+"."+"company";
    }

    private String setDept() {
        printInstructions();
        boolean flag;
        int dept;
        do {
            flag = false;
            System.out.print("Please select an option: ");
            dept = scanner.nextInt();
            switch (dept) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    return "Sales";
                case 2:
                    return "Technical";
                case 3:
                    return "Account";
                case 4:
                    return "Management";
                case 5:
                    return "Operation";
                case 6:
                    return " ";
                default:
                    System.out.println("Invalid Selection.");
            }

        } while (!flag);

        return null;
    }

//    private String selectDept(){
//        printInstructions();
//        boolean flag = false;
//        String dept = "";
//        while(!flag){
//            dept = getDept();
//            if(dept != null && dept.equalsIgnoreCase("quit")){
//                flag = true;
//            }
//        }
//        return dept;
//    }

    private String generatePassword(int length){
        Random random = new Random();
        String upCaseChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowCaseChar = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "~!@#$%^&*?";
        String values = upCaseChar+lowCaseChar+digits+symbols;
        StringBuilder password = new StringBuilder();
        for (int i = 0; i <length ; i++) {
            password.append(values.charAt(random.nextInt(values.length())));
        }
        return password.toString();
    }

    public void changePassword(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password?(Y/N)");
            char option = scanner.next().charAt(0);
            if(option == 'Y' || option == 'y'){
                flag = true;
                System.out.println("Enter your current password: ");
                String temp = scanner.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter a new password: ");
                    this.password = scanner.next();
                }else{
                    System.out.println("Incorrect password");
                }
            }else if(option == 'N' || option == 'n'){
                flag = true;
                System.out.println("Change password cancelled.");
            }else{
                System.out.println("Invalid selection");
            }
        }while (!flag);
    }

    public void setMailCapacity(){
        System.out.println("Current Mail capacity = "+this.mailCapacity+"mb");
        System.out.println("Enter new Mail Capacity:");
        this.mailCapacity = scanner.nextInt();
        System.out.println("New mail capacity = "+this.mailCapacity+"mb");
    }

    public void setAlternateEmail(){
        System.out.println("Enter alternate email: ");
        this.alternativeMail = scanner.next();
        System.out.println("Alternate email is set successfully");
    }

    public void displayInfo(){
        System.out.println("Name: "+ this.firstName+ " "+this.lastName + "\n"
                +"Department: "+ this.department + "\n"
                +"Email: " + this.email + "\n"
                +"Password: "+ this.password+ "\n"
                +"MailBox Capacity: "+ this.mailCapacity+"\n"
                +"Alternate Email: "+this.alternativeMail);
    }

    public void storeFile(){
        try{
            FileWriter fileWriter = new FileWriter("src/resources/emailAdministrator.txt");
            fileWriter.write("Name: "+ this.firstName + " " + this.lastName + "\n"
                            + "Email: "+ this.email + "\n"
                            + "Password: "+ this.password + "\n"
                            + "Mail Cap: "+ this.mailCapacity + "\n"
                            + "Alternate Email: "+ this.alternativeMail +"\n");


            fileWriter.close();
            System.out.println("Data stored...");
        }catch (IOException ex){
            System.out.println("Something went wrong." + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void readFile(){
        try{
            FileReader reader = new FileReader("src/resources/emailAdministrator.txt");
            int line;
            while( (line = reader.read()) !=-1){
                System.out.print((char) line);
            }
            System.out.println();
            reader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void printInstructions(){
        System.out.println("***************");
        System.out.println("Press \n"
                + "0 - For instructions \n"
                + "1 - To select \"Sales\" department\n"
                + "2 - To select \"IT\" department\n"
                + "3 - To select \"Account\" department\n"
                +"4 - To Select \"Management\" department\n"
                +"5 - To Select \"Operation\" department\n"
                +"6 - To quit");
    }
}
