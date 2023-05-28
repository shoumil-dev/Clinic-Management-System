package appointment;

public interface IAppointmentManager {
    /**
     * Adds an appointment to the list of existing appointments
     * @param patientId numeric ID of the patient
     * @param doctorId numeric ID of the doctor
     * @param date dd/mm/yyyy of appointment
     * @param appType the type of the appointment from the enum
     * @throws Exception if the inputs are not valid
     */
    void addAppointment(int patientId, int doctorId, String date, Appointment.AppointmentType appType)
        throws Exception;

    /**
     * Removes the specified appointment
     * @param appointmentId numeric value of the appointment's ID
     */
    void cancelAppointment(int appointmentId);

    /**
     * prints all appointments in the appointments list
     */
    void printAppointments();
}