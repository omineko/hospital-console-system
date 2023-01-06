

package database;

import java.util.ArrayList;
import java.util.HashMap;
import models.Doctor;
import models.User;


public class Doctors extends Users {

    public HashMap<String, String> create(HashMap<String, String> data) {
        HashMap<String, String> status = new HashMap<>();
        String NOT_SYMBOL_REGEX = "^[a-zA-Z]*$";
        
        status = super.checkAccount(data);

        // firstName must not contain special symbols
        if (!data.get("first-name").matches(NOT_SYMBOL_REGEX) || data.get("first-name").isBlank()) {
            status.put("status", "false");
            status.put("errType", "NAME_ILLEGAL_ERROR");

            return status;
        }

        // lastName must not contain special symbols
        if (!data.get("last-name").matches(NOT_SYMBOL_REGEX) || data.get("last-name").isBlank()) {
            status.put("status", "false");
            status.put("errType", "NAME_ILLEGAL_ERROR");

            return status;
        }

        // address is not blank
        if (data.get("address").isBlank()) {
            status.put("status", "false");
            status.put("errType", "NAME_ILLEGAL_ERROR");

            return status;
        }
        
        table.add(new Doctor(data));
        status.put("status", "true");
        status.put("errType", "SUCCESS");
        
        return status;
    }

    public void remove(String id) {
        super.remove(id, "doctor");
    }

    public User findOne(String id) {
        return super.findOne(id, "doctor");
    }

    public ArrayList<User> find() {
        return super.find("doctor");
    }

    @Override
    public void seed() {
        
    }

}
