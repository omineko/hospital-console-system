package controllers;

import database.Patients;
import java.util.ArrayList;
import java.util.HashMap;

public class Receptionist {
    public static ArrayList<HashMap<String, String>> addPatient(HashMap<String, String> data) {
        data.put("role", "patient");
        return new Patients().create(data);
    }
    
    public static void listPatients() {}
    
    public static void removePatient() {}
}
