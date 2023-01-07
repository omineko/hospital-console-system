package routes;

import java.util.HashMap;
import interfaces.Routes;
import java.util.Stack;

public abstract class Router implements Routes {
    private static Stack<String> history = new Stack<>();
    private static boolean isLoggedIn = false;
    
    public static void init() {
        routes.put("main-menu", mainMenu);
        routes.put("go-back", goBack);
        routes.put("quit", quit);
        routes.put("sign-out", signOut);
        
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
        routes.put("add-admin", addAdmin);
        routes.put("list-admins", listAdmins);
        routes.put("remove-admin", removeAdmin);
    }
    
    public static HashMap<String, Route> getRoutes() {
        return routes;
    }
    
    public static boolean toggleLoggedIn() {
        isLoggedIn = !isLoggedIn;
        return isLoggedIn;
    }
    
    public static void goBack() {
        if (history.size() > 1) {
            // TODO: Refactor this implementation later
            history.pop();
            history.pop();
            
            refresh();
        } else {
            // exit
            System.exit(0);
        }
    }
    
    public static void refresh() {
        navigate(history.peek());
    }
    
    public static String navigate(String routeName) {
        if (routes.containsKey(routeName)) {
            if (!history.isEmpty()) {
                if (!routeName.equals(history.peek())) history.add(routeName);
            } else history.add(routeName);
            
            return routes.get(routeName).navigate();
        }
        
        return "Route Not Found.";
    }
}
