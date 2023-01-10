package controllers;

import database.Doctors;
import database.Patients;
import database.Users;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;

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
    
    public static void removePatient() {}
}
