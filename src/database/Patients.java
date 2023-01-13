package database;

import static database.Users.table;
import java.util.ArrayList;
import java.util.HashMap;
import models.Patient;
import models.User;

public class Patients extends Users {
    
    @Override
    public ArrayList<HashMap<String, String>> create(HashMap<String, String> data) {
        ArrayList<HashMap<String, String>> errors = new ArrayList<>();
        String NOT_SYMBOL_REGEX = "^[a-zA-Z]*$";
        String VALID_NUMBER_REGEX = "\\d+";
        
        errors = super.checkAccount(data);
        
        // firstName is not blank
        if (data.get("first-name").isBlank()) {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "First Name");
            error.put("errType", "BLANK_ERROR");

            errors.add(error);
        }

        // firstName must not contain special symbols
        if (!data.get("first-name").matches(NOT_SYMBOL_REGEX)) {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "First Name");
            error.put("errType", "NAME_ILLEGAL_ERROR");

            errors.add(error);
        }
        
        // lastName is not blank
        if (data.get("last-name").isBlank()) {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "Last Name");
            error.put("errType", "BLANK_ERROR");

            errors.add(error);
        }

        // lastName must not contain special symbols
        if (!data.get("last-name").matches(NOT_SYMBOL_REGEX) ) {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "Last Name");
            error.put("errType", "NAME_ILLEGAL_ERROR");

            errors.add(error);
        }

        // address is not blank
        if (data.get("address").isBlank()) {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "Address");
            error.put("errType", "BLANK_ERROR");

            errors.add(error);
        }
        
        // contact is valid
        if (!data.get("contact").matches(VALID_NUMBER_REGEX) || data.get("contact").isBlank()) {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "Contact");
            error.put("errType", "NUMBER_ILLEGAL_ERROR");

            errors.add(error);
        }
        
        if (errors.isEmpty()) {
            table.add(new Patient(data));
        }
        
        return errors;
    }

    public ArrayList<HashMap<String, String>> remove(String id) {
        return super.remove(id, "patient");
    }

    public Patient findOne(String id) {
        return (Patient) super.findOne(id, "patient");
    }

    public ArrayList<User> find() {
        return super.find("patient");
    }
    
    public boolean update(Patient patient) {
        return super.update((User) patient);
    }

    @Override
    public void seed() {
        
    }

}
