package tools;

import java.util.Scanner;

public class MenuInput {
    public static int menuItem() {
        int choice=0;
        Scanner sel = new Scanner(System.in);
        System.out.println("+-------------------------------------+");
        System.out.println("|        Welcome to Bootcamp          |");
        System.out.println("|        Week 4  (Clinic App)         |");
        System.out.println("+-------------------------------------+");
        System.out.println("1) New Patient");
        System.out.println("2) New Doctor");
        System.out.println("3) List Patients");
        System.out.println("4) List Doctors");
        System.out.println("5) COVID Appointment");
        System.out.println("6) Add COVID Dose");
        System.out.println("7) Standard Appointment");
        System.out.println("8) Add Standard Appointment Case");
        System.out.println("9) List Appointments");
        System.out.println("10) Cancel Appointment");
        System.out.println("11) Exit");
        System.out.print("Select one:");
        choice = Integer.parseInt(sel.nextLine());
        System.out.println("Your choice:"+choice);
        return choice;
    }
}
