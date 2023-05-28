package tools;
import clinic.*;
public class ClinicDriver {

    public static void main(String[] args) throws Exception {
        Clinic clinic = Clinic.getInstance();
        clinic.runClinic();
    }
}
