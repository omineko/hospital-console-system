package controllers;

import database.Doctors;
import database.Users;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;
import models.Doctor;

public class Admin {
    public static ArrayList<HashMap<String, String>> addDoctor(HashMap<String, String> data) {
        data.put("role", "doctor");
        return new Doctors().create(data);
    }
    
    public static ArrayList<HashMap<String, String>> addReceptionist(HashMap<String, String> data) {
        data.put("role", "receptionist");
        return new Users().create(data);
    }
    
    public static ArrayList<HashMap<String, String>> addAdmin(HashMap<String, String> data) {
        data.put("role", "admin");
        return new Users().create(data);
    }
    
    public static boolean removeDoctor(String id) {
        return new Doctors().remove(id);
    }
    
    public static boolean removeReceptionist(String id) {
        return new Users().remove(id, "receptionist");
    }
    
    public static boolean removeAdmin(String id) {
        return new Users().remove(id, "admin");
    }
    
    public static User findReceptionist(String id) {
        return new Users().findOne(id, "receptionist");
    }
    
    public static Doctor findDoctor(String id) {
        return new Doctors().findOne(id);
    }
    
    public static User findAdmin(String id) {
        return new Users().findOne(id, "admin");
    }
    
    public static ArrayList<User> listDoctors() {
        return new Doctors().find();
    }
    
    public static ArrayList<User> listReceptionists() {
        return new Users().find("receptionist");
    }
    
    public static ArrayList<User> listAdmins() {
        return new Users().find("admin");
    }
}
