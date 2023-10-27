package UI;

import Model.Doctor;
import Model.Nurse;
import Model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    private static final Scanner scI = new Scanner(System.in);
    private static final Scanner scS = new Scanner(System.in);
    private static ArrayList<Doctor>doctors = new ArrayList<>();
    private static ArrayList<Patient>patients = new ArrayList<>();
    private static ArrayList<Nurse>nurses = new ArrayList<>();
    private static Doctor doctorLogged;
    private static Patient patientLogged;
    private static Nurse nurseLogged;
    public static void showMenu(){
        System.out.println("Welcome to Medical Appointments Heal.");
        System.out.println("Please, selected one option.");
        int responseInit = 0;
        do {
            int responseUser = 0;
            System.out.println("1. Login");
            System.out.println("2. sing in");
            System.out.println("0. Exit");
            responseInit = scI.nextInt();
            switch (responseInit){
                case 1:
                    responseUser = userChoseResponse();
                    authUser(responseUser);
                    break;
                case 2:
                    registerUser(userChoseResponse());
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
        return scI.nextInt();
    }

    public static void registerUser(int response){
        String name = "";
        String mail = "";
        String phoneNumber = "";
        String birthday = "";
        String speciality = "";
        String weight = "";
        String height = "";
        String blood = "";
        System.out.println("Insert you Name");
        name = scS.nextLine();
        System.out.println("Insert you Mail");
        mail = scS.nextLine();
        System.out.println("Insert you Phone Number");
        phoneNumber = scS.nextLine();
        System.out.println("Insert you Birthday");
        birthday = scS.nextLine();

        switch (response){
            case 1:
                System.out.println("Insert your speciality");
                speciality = scS.nextLine();
                doctors.add(new Doctor(name, mail, phoneNumber,birthday, speciality));
                showMenu();
                break;
            case 2:
                System.out.println("Insert your weight");
                weight = scS.nextLine();
                System.out.println("Insert your height");
                height = scS.nextLine();
                System.out.println("Insert your blood");
                blood = scS.nextLine();
                patients.add(new Patient(name, mail,phoneNumber,birthday,height, weight, blood));
                showMenu();
                break;
            case 3:
                System.out.println("Insert your speciality");
                speciality = scS.nextLine();
                nurses.add(new Nurse(name, mail,phoneNumber,birthday, speciality));
                showMenu();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Please Type a selected option.");
        }
    }

    public static void authUser(int response){
        String mail = "";
        boolean mailCorrect = false;

        do {
            System.out.println("Please typ your mail");
            mail = scS.nextLine();
            switch (response){
                case 1:
                    for (Doctor doc: doctors){
                        if(doc.getMail().equals(mail)){
                            mailCorrect = true;
                            doctorLogged = doc;
                            System.out.println(doctorLogged);
                            //code
                        }
                    }
                    break;
                case 2:
                    for (Patient pat: patients){
                        if(pat.getMail().equals(mail)){
                            mailCorrect = true;
                            patientLogged = pat;
                            System.out.println(patientLogged);
                            //code
                        }
                    }
                    break;
                case 3:
                    for(Nurse nr : nurses){
                        if(nr.getMail().equals(mail)){
                            mailCorrect = true;
                            nurseLogged = nr;
                            System.out.println(nurseLogged);
                        }
                    }
                    break;
                case 0:
                    mailCorrect = true;
                    showMenu();
                    break;
                default:
                    System.out.println("Please Type a selected option.");
            }
        }while(!mailCorrect);
    }
}
