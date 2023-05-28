package clinic;

import tools.Utils;

public class Doctor extends Person {
    private int id;
    private String specialty;
    static final int MAX_RANGE = 999;
    static final int MIN_RANGE = 100;

    public Doctor(String fullName, String address, String specialty) throws Exception {
        super(fullName, address);
        if (setSpecialty(specialty)) {
            generateID();
        }
        else {
            throw new Exception("Invalid Specialty");
        }
    }

    public int generateID() {
        setId(Utils.nextID(MIN_RANGE, MAX_RANGE));
        return id;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean setSpecialty(String specialty) {
        if (specialty.length() >= 2 && specialty.length() <= 10) {
            this.specialty = specialty;
            return true;
        }
        else return false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String printString = String.format("| %-10s| %-10s| %-10s| %-10s|", getId(), super.getFullName(), super.getAddress(), getSpecialty());
        return  printString;
    }
}
