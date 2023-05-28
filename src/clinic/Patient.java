package clinic;

import tools.Utils;

public class Patient extends Person {
    private int id;
    private String caseDescription;
    private final int MAX_RANGE = 9999999;
    static final int MIN_RANGE = 100000;

    public Patient(String fullName, String address, String caseDescription) throws Exception {
        super(fullName, address);
        setCaseDescription(caseDescription);
        generateID();
    }

    public int generateID() {
        setId(Utils.nextID(MIN_RANGE, MAX_RANGE));
        return id;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    @Override
    public String toString() {
        String printString = String.format("| %-10s| %-10s| %-10s| %-10s|", getId(), super.getFullName(), super.getAddress(), getCaseDescription());
        return  printString;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}