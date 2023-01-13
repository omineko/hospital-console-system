package routes;

import java.util.HashMap;
import interfaces.Routes;
import models.User;

/**
 * This class inherits the Routes interface.
 * 
 * This class functions as a navigator or router between different views.
 */

public abstract class Router implements Routes {
    private static User userSession;

    public static boolean isUserLoggedIn(User user) {
        return user.getId().equals(userSession.getId());
    }

    public static void setUserSession(User user) {
        Router.userSession = user;
    }

    public static User getUserSession() {
        return userSession;
    }
    
    public static void init() {
        routes.put("main-menu", mainMenu);
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
        
        // receptionist
        routes.put("add-patient", addPatient);
        routes.put("list-patients", listPatients);
        routes.put("assign-patient", assignPatient);
        routes.put("remove-patient", removePatient);
        
        // doctor
        routes.put("release-patient", releasePatient);
        routes.put("list-patients@doctor", listPatientsATDoctor);
        
        // patient
        routes.put("view-information", viewInformation);
    }
    
    public static HashMap<String, Route> getRoutes() {
        return routes;
    }
    
    public static void quit() {
        System.exit(0);
    }
    
    public static boolean peek(String routeName) {
        if (routes.containsKey(routeName)) return routes.get(routeName).peek();
        
        return false;
    }
    
    public static String navigate(String routeName) {
        if (routes.containsKey(routeName)) {
            return routes.get(routeName).navigate();
        }
        
        return "Route Not Found.";
    }
}
