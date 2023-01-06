

package models;

import java.util.HashMap;


public class Doctor extends User {
    private String firstName,
            lastName,
            address,
            department,
            contact;

    public Doctor(HashMap<String, String> data) {
        super(data.get("username"), data.get("password"), "doctor");
        
        this.firstName = data.get("first-name");
        this.lastName = data.get("last-name");
        this.address = data.get("address");
        this.department = data.get("department");
        this.contact = data.get("contact");
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

    public String getDepartment() {
        return department;
    }

    public String getContact() {
        return contact;
    }
}
