package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface IDB {
    public HashMap<String, String> create(HashMap<String, String> data);
    public void remove(String id, String role);
    public IModel findOne(String id, String role);
    public ArrayList<IModel> find(String role);
    public void seed();
}
