package controllers;

import database.Doctors;
import database.Patients;
import database.Users;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;
import models.Patient;
import routes.Router;

public class Doctor {
    public static ArrayList<HashMap<String, String>> releasePatient(String id) {
        User userSession = Router.getUserSession();
        models.Doctor doctor = new Doctors().findOne(userSession.getId());
        ArrayList<HashMap<String, String>> errors = new ArrayList<>();
        
        if (doctor.getPatients().contains(id)) {
            Patient patient = new Patients().findOne(id);
            
            if (patient != null) {
                if (!patient.isReleased()) {
                    patient.setIsReleased(true);
                } else {
                    HashMap<String, String> error = new HashMap<>();
                    error.put("path", "Patient");
                    error.put("errType", "Patient is already released");
                    errors.add(error);
                }
            } else {
                HashMap<String, String> error = new HashMap<>();
                error.put("path", "Patient");
                error.put("errType", "Patient does not exist.");
                errors.add(error);
            }
           
        } else {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "Patient");
            error.put("errType", "Patient does not exist.");
            errors.add(error);
        }
        
        return errors;
    }
    
    public static ArrayList<User> listPatients() {
        ArrayList<User> list = new ArrayList<>();
        User userSession = Router.getUserSession();
        
        if (userSession.getRole().equals("doctor")) {
            models.Doctor doctor = new Doctors().findOne(userSession.getId());
            ArrayList<String> patients = doctor.getPatients();
            
            for (User patient : new Patients().find()) {
                if (patients.contains(patient.getId())) {
                    System.out.println(patient.getUsername());
                    list.add(patient);
                }
            }
        }
        
        return list;
    }
    
    public static Patient findPatient(String id) {
        models.Doctor userSession = (models.Doctor) Router.getUserSession();
        
        if (userSession.getRole().equals("doctor") && userSession.getPatients().contains(id)) {
            return new Patients().findOne(id);
        }
        
        return null;
    }
}
