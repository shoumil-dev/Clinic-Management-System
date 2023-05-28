package clinic;

public abstract class Person {

    private String fullName;
    private String address;
    private int id;

    public Person(String fullName, String address) throws Exception {
        if (setFullName(fullName) && setAddress(address)) {
            ;
        }else{
            this.id = 0;
            throw new Exception("Incorrect Person's details ");
        }
    }

    public String getFullName() {
        return fullName;
    }

    public boolean setFullName(String fullName) {
        if (fullName.length() >= 3 && fullName.length() <= 15) {
            this.fullName = fullName;
            return true;
        }
        else return false;
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        if (address.length() >= 3 && address.length() <= 15) {
            this.address = address;
            return true;
        }
        else return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract int generateID();

    public String toString() {
        return "Full name = " + getFullName() + "   and lives in " + getAddress() + "   , ";
    }
}
