package interfaces;

import java.util.HashMap;
import routes.Route;
import views.AdminLogin;
import views.DoctorLogin;
import views.MainMenu;
import views.PatientLogin;
import views.ReceptionistLogin;

public interface Routes {
    HashMap<String, Route> routes = new HashMap<>();
    Route mainMenu = new Route("Main Menu", new MainMenu());
    Route adminLogin = new Route("Administrator Login", new AdminLogin());
    Route doctorLogin = new Route("Doctor Login", new DoctorLogin());
    Route patientLogin = new Route("Patient Login", new PatientLogin());
    Route receptionistLogin = new Route("Receptionist Login", new ReceptionistLogin());
}
