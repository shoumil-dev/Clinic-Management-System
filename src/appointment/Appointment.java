package appointment;
import tools.*;

/**
 * implements the Appointment Class
 * @author Shoumil Guha sguh0003@student.monash.edu
 */
public abstract class Appointment {

    private int appointmentID;
    private int patientID;
    private int doctorID;
    private String date;
    static final int MAX_ID = 9999999;
    static final int MIN_ID = 1000000;

    static final int DATE_LENGTH = 10;

    AppointmentType appType;

    /**
     * creates an appointment object
     * @param patientId
     * @param appType
     * @param date
     * @param doctorId
     * @throws Exception if the inputs are invalid
     */
    public Appointment(int patientId, int doctorId, String date, Appointment.AppointmentType appType)
        throws Exception {
        if (setDate(date)) {
            this.patientID = patientId;
            this.doctorID = doctorId;
            setAppointmentID();
        }
        else {
            throw new Exception("Invalid date");
        }
    }

    public abstract String getSpecial();

    public enum AppointmentType {COVID, STANDARD}
    /**
     * sets the date if the input date is valid
     * @param date a date in the form dd/mm/yyyy
     * @return false if invalid
     */
    public boolean setDate(String date) {
        if (date.length() == DATE_LENGTH) {
            this.date = date;
            return true;
        }
        else return false;
    }

    private void setAppointmentID(){
        this.appointmentID = Utils.nextID(MIN_ID, MAX_ID);
    }

    /**
     * gets the appointment ID of the appointment
     * @return the number of the appointment
     */
    public int getAppointmentID() {
        return appointmentID;
    }
}
