package controllers;

import database.Users;
import interfaces.IModel;
import java.util.ArrayList;
import java.util.HashMap;
import routes.Router;

public class Auth {
    public static HashMap<String, String> register(HashMap<String, String> data) {
        return new Users().create(data);
    }
    
    public static boolean login(HashMap<String, String> data) {
        ArrayList<IModel> users = new Users().find(data.get("role"));
        
        for (IModel user : users) {
            String username = user.getUsername();
            String password = user.getPassword();
            
            if (username.equals(data.get("username")) && password.equals(data.get("password"))) {
                return true;
            }
        }
        
        return false;
    }
}
