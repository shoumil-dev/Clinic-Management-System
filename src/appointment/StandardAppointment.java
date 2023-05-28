package appointment;

public class StandardAppointment extends Appointment {
    private String caseDescription;

    public StandardAppointment(int patientId, int doctorId, String date, AppointmentType appType)
        throws Exception {
        super(patientId, doctorId, date, appType);
    }

    public boolean addCaseDescription(String caseDesc) throws Exception {
        if (caseDesc.length() >= 5 && caseDesc.length() <= 15) {
            this.caseDescription = caseDesc;
            return true;
        }
        else {
            throw new Exception("Invalid case description");
        }
    }

    @Override
    public String getSpecial() {
        return String.format("{case Desc: '%s'}", this.caseDescription);
    }
}
