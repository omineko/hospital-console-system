package controllers;

import database.Doctors;
import database.Users;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;
import models.Doctor;

public class Admin {
    public static HashMap<String, String> addDoctor(HashMap<String, String> data) {
        data.put("role", "doctor");
        return new Doctors().create(data);
    }
    
    public static HashMap<String, String> addReceptionist(HashMap<String, String> data) {
        data.put("role", "receptionist");
        return new Users().create(data);
    }
    
    public static boolean removeDoctor(String id) {
        return new Doctors().remove(id);
    }
    
    public static boolean removeReceptionist(String id) {
        return new Users().remove(id, "receptionist");
    }
    
    public static User findReceptionist(String id) {
        return new Users().findOne(id, "receptionist");
    }
    
    public static Doctor findDoctor(String id) {
        return new Doctors().findOne(id);
    }
    
    public static ArrayList<User> listDoctors() {
        return new Doctors().find();
    }
    
    public static ArrayList<User> listReceptionists() {
        return new Users().find("receptionist");
    }
}
