package controllers;

import database.Doctors;
import database.Patients;
import database.Users;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;
import models.Doctor;
import models.Patient;

public class Receptionist {
    public static ArrayList<HashMap<String, String>> addPatient(HashMap<String, String> data) {
        data.put("role", "patient");
        return new Patients().create(data);
    }
    
    public static ArrayList<User> listPatients() {
        return new Users().find("patient");
    }
    
    public static ArrayList<User> listDoctors() {
        return new Doctors().find();
    }
    
    public static ArrayList<HashMap<String, String>> assignPatient(String doctorId, String patientId) {
        ArrayList<HashMap<String, String>> errors = new ArrayList<>();
        Doctor doctor = findDoctor(doctorId);
        Patient patient = findPatient(patientId);
        
        if (doctor == null) {
            HashMap<String, String> error = new HashMap<>();
            
            error.put("path", "Doctor");
            error.put("errType", "NOT_FOUND");
        }
        
        if (patient == null) {
            HashMap<String, String> error = new HashMap<>();
            
            error.put("path", "Patient");
            error.put("errType", "NOT_FOUND");
        }
        
        if ((doctor != null) && (patient != null)) {
            doctor.setPatient(patient.getId());
        }
        
        return errors;
        
    }
    
    public static Doctor findDoctor(String id) {
        return new Doctors().findOne(id);
    }
    
    public static Patient findPatient(String id) {
        return new Patients().findOne(id);
    }
    
    public static void removePatient() {}
}
