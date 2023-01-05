package database;

import interfaces.IDB;
import java.util.ArrayList;
import java.util.HashMap;
import models.User;

public class Users implements  IDB {
    private static ArrayList<User> table = new ArrayList<User>();

    @Override
    public void create(HashMap<String, String> data) {
        table.add(new User(data.get("username"), data.get("password")));
    }

    @Override
    public void remove(String id) {
        for (User user : table) {
            if (user.getId().equals(id)) {
                table.remove(user);
            }
        }
    }

    @Override
    public void get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
