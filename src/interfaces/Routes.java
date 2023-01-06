package interfaces;

import java.util.HashMap;
import routes.Route;
import views.login.*;
import views.MainMenu;
import views.admin.AddDoctor;
import views.admin.AddReceptionist;
import views.admin.ListDoctors;
import views.admin.ListReceptionists;
import views.admin.RemoveDoctor;
import views.admin.RemoveReceptionist;
import views.dashboard.*;

public interface Routes {
    HashMap<String, Route> routes = new HashMap<>();
    Route mainMenu = new Route("Main Menu", new MainMenu());
    
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
}
