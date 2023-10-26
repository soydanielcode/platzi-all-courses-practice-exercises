package UI;

import java.util.Scanner;

public class UIMenu {

    private static Scanner sc = new Scanner(System.in);
    public static void showMenu(){
        System.out.println("Welcome to Medical Appointments Heal.");
        System.out.println("Please, selected one option.");
        int responseInit = 0;
        do {
            System.out.println("1. Login");
            System.out.println("2. sing in");
            System.out.println("0. Exit");
            responseInit = sc.nextInt();
            switch (responseInit){
                case 1:
                    responseInit = 0;
                    userChoseResponse();
                    break;
                case 2:
                    responseInit = 0;
                    userChoseResponse();
                    break;
                case 0:
                    System.out.println("Thanks for you, see you again.");
                    break;
                default:
                    System.out.println("Please Type a selected option.");
            }
        }while(responseInit != 0);
    }

    public static int userChoseResponse(){
        System.out.println("What type of user are you?");
        System.out.println("1. Doctor");
        System.out.println("2. Patient");
        System.out.println("3. Nurse");
        System.out.println("0. Exit");
        return sc.nextInt();
    }

    public static void registerUser(){
        String name = "";
        String mail = "";
        System.out.println("Insert you Name");
        name = sc.nextLine();
        System.out.println("Insert you Mail");
        mail = sc.nextLine();
        //Add list of Doctor Patient or Nurse
    }
}
