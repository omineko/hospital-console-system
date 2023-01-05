package database;

import interfaces.IDB;
import interfaces.IModel;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;

public class Users implements IDB {
    private static ArrayList<IModel> table = new ArrayList<>();

    @Override
    public HashMap<String, String> create(HashMap<String, String> data) {
        HashMap<String, String> status = new HashMap<>();
        
        for (IModel user : table) {
            if (user.getRole().equals(data.get("role"))) {
                // username is unique
                if (user.getUsername().equals(data.get("username"))) {
                    status.put("status", "false");
                    status.put("errType", "USERNAME_UNIQ_ERROR");
                    
                    return status;
                };
                
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
                
                table.add(new User(data.get("username"), data.get("password"), data.get("role")));
                status.put("status", "true");
                status.put("errType", "USERNAME_UNIQ_ERROR");
                
                return status;
            }
        }
        
        status.put("status", "false");
        status.put("errType", "GENERIC_ERROR");

        return status;
    }

    @Override
    public void remove(String id, String role) {
        for (IModel user : table) {
            if (user.getId().equals(id) && user.getRole().equals(role)) {
                table.remove(user);
            }
        }
    }

    @Override
    public IModel findOne(String id, String role) {
        for (IModel user : table) {
            if (user.getId().equals(id) && user.getRole().equals(role)) {
                return user;
            }
        }
        
        return null;
    }

    @Override
    public ArrayList<IModel> find(String role) {
        ArrayList<IModel> users = new ArrayList<>();
        
        for (IModel user : table) {
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
