package interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import models.User;

public interface IDB {
    public ArrayList<HashMap<String, String>> create(HashMap<String, String> data);
    public boolean remove(String id, String role);
    public User findOne(String id, String role);
    public ArrayList<User> find(String role);
    public void seed();
}
