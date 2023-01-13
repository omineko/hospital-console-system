package database;

import interfaces.IDB;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;
import routes.Router;

public class Users implements IDB {
    protected static ArrayList<User> table = new ArrayList<>();
    
    protected ArrayList<HashMap<String, String>> checkAccount(HashMap<String, String> data) {
        ArrayList<HashMap<String, String>> errors = new ArrayList<>();
        String VALID_USERNAME_REGEX = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        
        for (User user : table) {
            if (user.getRole().equals(data.get("role"))) {
                // username is unique
                if (user.getUsername().equals(data.get("username"))) {
                    HashMap<String, String> error = new HashMap<>();
                    error.put("path", "Username");
                    error.put("errType", "UNIQ_ERROR");
                    
                    errors.add(error);
                }
            }
        }

        // username is not blank
        if (data.get("username").isBlank()) {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "Username");
            error.put("errType", "BLANK_ERROR");

            errors.add(error);
        }
        
        // username is valid
        if (!data.get("username").matches(VALID_USERNAME_REGEX)) {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "Username");
            error.put("errType", "INVALID_ERROR");

            errors.add(error);
        }

        // password is not blank
        if (data.get("password").isBlank()) {
            HashMap<String, String> error = new HashMap<>();
            error.put("path", "Password");
            error.put("errType", "BLANK_ERROR");

            errors.add(error);
        }
        
        return errors;
    }

    @Override
    public ArrayList<HashMap<String, String>> create(HashMap<String, String> data) {
        ArrayList<HashMap<String, String>> errors = this.checkAccount(data);
        
        if (errors.isEmpty()) {
            table.add(new User(data.get("username"), data.get("password"), data.get("role"))); 
        }

        return errors;
    }

    @Override
    public ArrayList<HashMap<String, String>> remove(String id, String role) {
        ArrayList<HashMap<String, String>> errors = new ArrayList<>();
        
        for (User user : table) {
            if (user.getId().equals(id) && user.getRole().equals(role)) {
                // if id is in session
                if (Router.isUserLoggedIn(user)) {
                    HashMap<String, String> error = new HashMap<>();
                    error.put("path", user.getRole());
                    error.put("errType", "SESSION_NOT_EXPIRED");
                    errors.add(error);
                    
                    return errors;
                } else {
                    table.remove(user);
                    return errors; 
                }
            }
        }

        HashMap<String, String> error = new HashMap<>();
        error.put("path", role);
        error.put("errType", "NOT_FOUND");
        errors.add(error);
        
        return errors;
    }

    @Override
    public User findOne(String id, String role) {
        for (User user : table) {
            if (user.getId().equals(id) && user.getRole().equals(role)) {
                return user;
            }
        }
        
        return null;
    }

    @Override
    public ArrayList<User> find(String role) {
        ArrayList<User> users = new ArrayList<>();
        
        for (User user : table) {
            if (user.getRole().equals(role)) {
                users.add(user);
            }
        }
        return users;
    }
    
    public boolean update(User user) {
        ArrayList<HashMap<String, String>> errors = this.remove(user.getId(), user.getRole());
        
        if (errors.isEmpty()) {
            table.add(user);
            return true;
        } else return false;
    }

    @Override
    public void seed() {
        table.add(new User("admin1", "pwd", "admin"));
        table.add(new User("recep1", "pwd", "receptionist"));
    }
}
