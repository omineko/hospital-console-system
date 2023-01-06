package controllers;

import database.Doctors;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;

public class Admin {
    public static HashMap<String, String> addDoctor(HashMap<String, String> data) {
        return new Doctors().create(data);
    }
    
    public static void addReceptionist() {}
    
    public static void removeDoctor() {}
    
    public static void removeReceptionist() {}
    
    public static ArrayList<User> listDoctors() {
        return new Doctors().find();
    }
    
    public static void listReceptionists() {}
}
