package interfaces;

import java.util.HashMap;
import routes.Route;
import views.login.*;
import views.*;
import views.admin.*;
import views.dashboard.*;

/**
 * This is an abstraction of all Route classes. Each class is assigned to a variable which
 * then inherited by the subclass Router
**/

public interface Routes {
    HashMap<String, Route> routes = new HashMap<>();
    
    // main view
    Route mainMenu = new Route("Main Menu", new MainMenu());
    Route goBack = new Route("Go Back", new GoBack());
    Route quit = new Route("Quit", new Quit());
    Route signOut = new Route("Sign Out", new SignOut());
    
    // login
    Route adminLogin = new Route("Administrator Login", new AdminLogin());
    Route doctorLogin = new Route("Doctor Login", new DoctorLogin());
    Route patientLogin = new Route("Patient Login", new PatientLogin());
    Route receptionistLogin = new Route("Receptionist Login", new ReceptionistLogin());
    
    // dashboard
    Route adminDashboard = new Route("Administrator Dashboard", new AdminDashboard());
    Route doctorDashboard = new Route("Doctor Dashboard", new DoctorDashboard());
    Route patientDashboard = new Route("Patient Dashboard", new PatientDashboard());
    Route receptionistDashboard = new Route("Receptionist Dashboard", new ReceptionistDashboard());
    
    // admin
    Route addDoctor = new Route("Add Doctor", new AddDoctor());
    Route addReceptionist = new Route("Add Receptionist", new AddReceptionist());
    Route listDoctors = new Route("List Doctors", new ListDoctors());
    Route listReceptionists = new Route("List Receptionists", new ListReceptionists());
    Route removeDoctor = new Route("Remove Doctor", new RemoveDoctor());
    Route removeReceptionist = new Route("Remove Receptionists", new RemoveReceptionist());
    Route addAdmin = new Route("Add Admin", new AddAdmin());
    Route listAdmins = new Route("List Admins", new ListAdmins());
    Route removeAdmin = new Route("Remove Admin", new RemoveAdmin());
}
