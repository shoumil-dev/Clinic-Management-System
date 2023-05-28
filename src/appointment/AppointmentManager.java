

package appointment;
import clinic.Clinic;

import java.util.HashMap;
import java.util.Scanner;

/**
 * implements the AppointmentManager Class
 * @author Shoumil Guha sguh0003@student.monash.edu
 */
public class AppointmentManager implements IAppointmentManager{
    private AppointmentManager(){}
    static AppointmentManager myAppointmentManager;
    private HashMap<Integer, Appointment> appointments = new HashMap<Integer, Appointment>();

    /**
     * Creates an instance of the appointment manager
     * @return an appointmentManager object
     */
    public static AppointmentManager getInstance() {
        if (myAppointmentManager == null) {
            myAppointmentManager = new AppointmentManager();
            return myAppointmentManager;
        }
        else {
            return null;
        }
    }

    /**
     * Adds an appointment to the list of existing appointments
     * @param patientId numeric ID of the patient
     * @param doctorId numeric ID of the doctor
     * @param date dd/mm/yyyy of appointment
     * @param appType the type of the appointment from the enum
     * @throws Exception if the inputs are not valid
     */
    @Override
    public void addAppointment(int patientId, int doctorId, String date, Appointment.AppointmentType appType)
        throws Exception {
        switch (appType) {
            case COVID:
                CovidAppointment newCovid = new CovidAppointment(patientId, doctorId, date, appType);
                appointments.put(newCovid.getAppointmentID(), newCovid);
                break;
            case STANDARD:
                StandardAppointment newStandard = new StandardAppointment(patientId, doctorId, date, appType);
                appointments.put(newStandard.getAppointmentID(), newStandard);
                break;
        }
    }

    /**
     * Searches for and returns the found appointment object
     * @param appointmentID numeric value of the appointment's ID
     * @return the appointment object
     */
    public Appointment getAppointment(int appointmentID) {
        return appointments.get(appointmentID);
    }

    /**
     * Removes the specified appointment
     * @param appointmentId numeric value of the appointment's ID
     */
    @Override
    public void cancelAppointment(int appointmentId) {
        appointments.remove(appointmentId);
    }

    /**
     * prints all appointments in the appointments list
     */
    @Override
    public void printAppointments() {
        System.out.println(String.format("| %-10s| %-10s|", " ID", " Appointment"));
        System.out.println("-------------------------");
        for (Appointment appointment : appointments.values()) {
            System.out.println(String.format("| %-10s| %-10s|", appointment.getAppointmentID(), appointment.getSpecial()));
        }
    }
}
