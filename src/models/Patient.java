package models;

import java.util.HashMap;

public class Patient extends User {
    private String firstName,
            lastName,
            address,
            contact,
            sex,
            bloodType,
            initialDiagnosis;
    private boolean isReleased;

    public Patient(HashMap<String, String> data) {
        super(data.get("username"), data.get("password"), "patient");
        
        this.firstName = data.get("first-name");
        this.lastName = data.get("last-name");
        this.address = data.get("address");
        this.contact = data.get("contact");
        this.sex = data.get("sex");
        this.bloodType = data.get("blood-type");
        this.initialDiagnosis = data.get("initial-diagnosis");
        this.isReleased = false;
    }

    public boolean isReleased() {
        return isReleased;
    }

    public void setIsReleased(boolean isReleased) {
        this.isReleased = isReleased;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getSex() {
        return sex;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getInitialDiagnosis() {
        return initialDiagnosis;
    }
    
    
}
