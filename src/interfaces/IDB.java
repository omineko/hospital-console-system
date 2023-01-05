package interfaces;

import java.util.HashMap;

public interface IDB {
    public void create(HashMap<String, String> data);
    public void remove(String id);
    public void get(String id);
    public void getAll();
}
