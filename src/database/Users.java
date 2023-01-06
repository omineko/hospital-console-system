package database;

import interfaces.IDB;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;

public class Users implements IDB {
    protected static ArrayList<User> table = new ArrayList<>();
    
    protected HashMap<String, String> checkAccount(HashMap<String, String> data) {
        HashMap<String, String> status = new HashMap<>();
        
        for (User user : table) {
            if (user.getRole().equals(data.get("role"))) {
                // username is unique
                if (user.getUsername().equals(data.get("username"))) {
                    status.put("status", "false");
                    status.put("errType", "USERNAME_UNIQ_ERROR");
                    
                    return status;
                }
            }
        }

        // username is not blank
        if (data.get("username").isBlank()) {
            status.put("status", "false");
            status.put("errType", "USERNAME_BLANK_ERROR");

            return status;
        }

        // password is not blank
        if (data.get("password").isBlank()) {
            status.put("status", "false");
            status.put("errType", "PASSWORD_BLANK_ERROR");

            return status;
        }
        
        status.put("status", "true");
        status.put("errType", "SUCCESS");

        return status;
    }

    @Override
    public HashMap<String, String> create(HashMap<String, String> data) {
        table.add(new User(data.get("username"), data.get("password"), data.get("role")));

        return this.checkAccount(data);
    }

    @Override
    public void remove(String id, String role) {
        for (User user : table) {
            if (user.getId().equals(id) && user.getRole().equals(role)) {
                table.remove(user);
            }
        }
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

    @Override
    public void seed() {
        table.add(new User("admin1", "pwd", "admin"));
        table.add(new User("patient1", "pwd", "patient"));
    }
}
