package clinic;
import appointment.*;
import tools.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Clinic {
    static Clinic myClinic;
    private Clinic(){}
    public AppointmentManager appointmentManager = AppointmentManager.getInstance();
    public ArrayList<Patient> patients = new ArrayList<Patient>();
    public ArrayList<Doctor> doctors = new ArrayList<Doctor>();

    /**
     * creates an instance of the clinic
     * @return a clinic object
     */
    public static Clinic getInstance() {
        if (myClinic == null) {
            myClinic = new Clinic();
            return myClinic;
        }
        else {
            return null;
        }
    }

    /**
     * Adds a new doctor
     * @throws Exception if inputs are not valid
     */
    public void createDoctor() throws Exception {
        String name, address, specialty;
        Scanner sel = new Scanner(System.in);
        System.out.print("Enter Doctor Name: ");
        name = sel.nextLine();
        System.out.print("Enter Doctor Address: ");
        address = sel.nextLine();
        System.out.print("Enter Doctor Specialty: ");
        specialty = sel.nextLine();
        Doctor doctor = new Doctor(name, address, specialty);
        doctors.add(doctor);
    }

    /**
     * Adds a new patient
     * @throws Exception if inputs are not valid
     */
    public void createPatient() throws Exception {
        String name, address, caseDesc;
        Scanner sel = new Scanner(System.in);
        System.out.print("Enter Patient Name: ");
        name = sel.nextLine();
        System.out.print("Enter Patient Address: ");
        address = sel.nextLine();
        System.out.print("Enter Patient Case: ");
        caseDesc = sel.next();
        Patient patient = new Patient(name, address, caseDesc);
        patients.add(patient);
    }

    /**
     * Lists all patients
     */
    public void listPatients() {
        System.out.println(String.format("| %-10s| %-10s| %-10s| %-10s|", "ID", "Name", "Address", "Case"));
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i).toString());
        }
        System.out.println("Press Enter key to continue...");
        try{System.in.read();}
            catch(Exception e){}
    }

    /**
     * Lists all doctors
     */
    public void listDoctors() {
        System.out.println(String.format("| %-10s| %-10s| %-10s| %-10s|", " ID", " Name", " Address", " Specialty"));
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println(doctors.get(i).toString());
        }
        System.out.println("Press Enter key to continue...");
        try{System.in.read();}
        catch(Exception e){}
    }

    /**
     * starts the clinic program
     * @throws Exception if invalid values and put in
     */
    public void runClinic() throws Exception {
        int menuItem = 0;
        while (menuItem != 11) {
            menuItem = MenuInput.menuItem();
            Scanner feeder = new Scanner(System.in);
            switch (menuItem) {
                case 1:
                    createPatient();
                    break;
                case 2:
                    createDoctor();
                    break;
                case 3:
                    listPatients();
                    break;
                case 4:
                    listDoctors();
                case 5:
                    int patientID;
                    int doctorID;
                    String date;
                    try {
                        System.out.println("Enter Patient ID:");
                        patientID = Integer.parseInt(feeder.nextLine());
                        System.out.println("Enter Doctor ID:");
                        doctorID = Integer.parseInt(feeder.nextLine());
                        System.out.println("Enter Date:");
                        date = feeder.nextLine();
                        appointmentManager.addAppointment(patientID, doctorID, date, Appointment.AppointmentType.COVID);
                    } catch (Exception e) {
                        System.out.println("Error: Please do not use invalid values ");
                    }
                    break;
                case 6:
                    int appointmentID;
                    try {
                        System.out.println("Enter Appointment ID:");
                        appointmentID = Integer.parseInt(feeder.nextLine());
                        System.out.println("Enter Dose Date:");
                        String doseDate = feeder.nextLine();
                        CovidAppointment currentCovidAppointment = (CovidAppointment) appointmentManager.getAppointment(appointmentID);
                        currentCovidAppointment.addDoseDate(doseDate);
                    } catch (Exception e) {
                        System.out.println("Error: Please do not use invalid values ");
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Enter Patient ID:");
                        patientID = Integer.parseInt(feeder.nextLine());
                        System.out.println("Enter Doctor ID:");
                        doctorID = Integer.parseInt(feeder.nextLine());
                        System.out.println("Enter Date:");
                        date = feeder.nextLine();
                        appointmentManager.addAppointment(patientID, doctorID, date, Appointment.AppointmentType.STANDARD);
                    } catch (Exception e) {
                        System.out.println("Error: Please do not use invalid values ");
                    }
                    break;
                case 8:
                    try {
                        System.out.println("Enter Appointment ID:");
                        appointmentID = Integer.parseInt(feeder.nextLine());
                        System.out.println("Enter Appointment Case Description:");
                        String caseDesc = feeder.nextLine();
                        StandardAppointment currentStandardAppointment = (StandardAppointment) appointmentManager.getAppointment(appointmentID);
                        currentStandardAppointment.addCaseDescription(caseDesc);
                    } catch (Exception e) {
                        System.out.println("Error: Please do not use invalid values ");
                    }
                    break;
                case 9:
                    appointmentManager.printAppointments();
                    break;
                case 10:
                    try {
                        System.out.println("Enter Appointment ID:");
                        appointmentID = Integer.parseInt(feeder.nextLine());
                        appointmentManager.cancelAppointment(appointmentID);
                    } catch (Exception e) {
                        System.out.println("Error: Please do not use invalid values ");
                    }
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Error: Please choose a valid option ");
            }
        }
        System.out.println("Thank you for visiting FIT2099 Clinic App");
    }
}