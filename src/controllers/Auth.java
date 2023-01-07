package controllers;

import database.Users;
import java.util.ArrayList;
import java.util.HashMap;
import routes.Router;
import models.User;

public class Auth {
    public static ArrayList<HashMap<String, String>> register(HashMap<String, String> data) {
        return new Users().create(data);
    }
    
    public static boolean login(HashMap<String, String> data) {
        ArrayList<User> users = new Users().find(data.get("role"));
        
        for (User user : users) {
            String username = user.getUsername();
            String password = user.getPassword();
            
            if (username.equals(data.get("username")) && password.equals(data.get("password"))) {
                return true;
            }
        }
        
        return false;
    }
}
