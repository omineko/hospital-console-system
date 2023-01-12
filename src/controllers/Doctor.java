

package controllers;

import database.Patients;
import database.Users;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;
import models.Patient;

public class Doctor {
    public static ArrayList<HashMap<String, String>> releasePatient(String id) {
        Patient patient = new Patients().findOne(id);
        ArrayList<HashMap<String, String>> errors = new ArrayList<>();
        
        if (patient != null) {
            
            if (!patient.isReleased()) {
                patient.setIsReleased(true);
                new Patients().update(patient);
            } else {
                errors.add(addError("Patient is already released"));
            }
           
        } else errors.add(addError("Patient ID not found"));
        
        return errors;
    }
    
    public static ArrayList<User> listPatients() {
        return new Users().find("patient");
    }
    
    private static HashMap<String, String> addError(String errType) {
        HashMap<String, String> error = new HashMap<>();

        error.put("errType", errType);
        
        return error;
    }
}
