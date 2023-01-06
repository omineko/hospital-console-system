package routes;

import java.util.HashMap;
import interfaces.Routes;

public abstract class Router implements Routes {
    
    public static void init() {
        routes.put("main-menu", mainMenu);
        
        // login
        routes.put("admin-login", adminLogin);
        routes.put("doctor-login", doctorLogin);
        routes.put("patient-login", patientLogin);
        routes.put("receptionist-login", receptionistLogin);
        
        // dashboard
        routes.put("admin-dashboard", adminDashboard);
        routes.put("doctor-dashboard", doctorDashboard);
        routes.put("patient-dashboard", patientDashboard);
        routes.put("receptionist-dashboard", receptionistDashboard);
        
        // admin
        routes.put("add-doctor", addDoctor);
        routes.put("add-receptionist", addReceptionist);
        routes.put("list-doctors", listDoctors);
        routes.put("list-receptionists", listReceptionists);
        routes.put("remove-doctor", removeDoctor);
        routes.put("remove-receptionist", removeReceptionist);
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
