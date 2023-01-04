package routes;

import java.util.HashMap;
import interfaces.Routes;

public abstract class Router implements Routes {
    
    public static void init() {
        routes.put("main-menu", mainMenu);
        routes.put("admin-login", adminLogin);
        routes.put("doctor-login", doctorLogin);
        routes.put("patient-login", patientLogin);
        routes.put("receptionist-login", receptionistLogin);
    }
    
    public static HashMap<String, Route> getRoutes() {
        return routes;
    }
    
    public static void navigate(String routeName) {
        if (routes.containsKey(routeName)) {
            routes.get(routeName).navigate();
        }
    }
}
