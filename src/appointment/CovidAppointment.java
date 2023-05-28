package appointment;

import java.util.ArrayList;

public class CovidAppointment extends Appointment {
    private ArrayList<String> doses = new ArrayList<String>();

    public CovidAppointment(int patientId, int doctorId, String date, AppointmentType appType)
        throws Exception {
        super(patientId, doctorId, date, appType);
    }

    public void addDoseDate(String date) {
        doses.add(date);
    }

    @Override
    public String getSpecial() {
        return String.format("{doses=%s}", doses.toString());
    }
}
