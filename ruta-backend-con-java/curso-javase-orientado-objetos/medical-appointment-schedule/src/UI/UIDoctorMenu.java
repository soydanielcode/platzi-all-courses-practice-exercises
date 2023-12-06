package UI;

import Model.Doctor;

import java.text.ParseException;
import java.util.ArrayList;

public class UIDoctorMenu {
    private final static ArrayList<Doctor> availableAppointmentDoctors = new ArrayList<>();
    public static void showMenuDoctor() throws ParseException{
        int response;
        do {
            System.out.println("\n");
            System.out.println("Welcome Dr: " + UIMenu.doctorLogged.getNames());
            System.out.println("Please selected one option.");
            System.out.println("1. Add available Appointment.");
            System.out.println("2. My scheduled Appointment.");
            System.out.println("0. Logout.");
            response = UIMenu.scI.nextInt();
            switch(response){
                case 1:
                    showAddAppointmentAvailableMenu();
                    break;
                case 2:
                    showMyAppointmentsScheduled();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Please Type a selected correct option.");
            }
        }while(response!=0);
    }
    private static void showAddAppointmentAvailableMenu() throws ParseException{
        int responseDate;
        int responseTime;
        String date;
        String time;
        do {
            System.out.println(":: Add Appointments");
            System.out.println("Please type the date in this format: [dd/mm/yyyy] ");
            date = UIMenu.scS.nextLine();
            System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
            responseDate = UIMenu.scI.nextInt();
            if (responseDate == 2){continue;}
            do {
                System.out.println("Please type the time in this format: [hh:mm] ");
                time = UIMenu.scS.nextLine();
                System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Date");
                responseTime = UIMenu.scI.nextInt();
            }while(responseTime == 2);
            UIMenu.doctorLogged.addAvailableAppointments(date, time);
            checkDoctorAvailableAppointment();
            System.out.println("Do  you want add Available Appointment? \n1. yes \n0.No");
            responseDate = UIMenu.scI.nextInt();
        }while(responseDate!=0);
        showMenuDoctor();
    }

    private static void showMyAppointmentsScheduled(){
        System.out.println("\n");
        System.out.println("::My Appointment Scheduled");
        if(!UIMenu.doctorLogged.getAvailableAppointments().isEmpty()){
            System.out.println("Date\t" + "\tTime\t");
            for(Doctor.AvailableAppointment ad : UIMenu.doctorLogged.getAvailableAppointments()){
                System.out.println(ad.getDate() +"\t" + ad.getTime() + "\t");
            }
            return;
        }
        System.out.println("---No appointment schedules yet---");
    }
    private static void checkDoctorAvailableAppointment(){
        if(UIMenu.doctorLogged.getAvailableAppointments().isEmpty()
            && !availableAppointmentDoctors.contains(UIMenu.doctorLogged)){
            availableAppointmentDoctors.add(UIMenu.doctorLogged);
        }
    }
}
