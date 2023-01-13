package views.patient;

import interfaces.IDefaultView;
import java.util.Formatter;
import layouts.Banner;
import layouts.Halter;
import models.Patient;
import models.User;
import routes.Router;

public class ViewInformation implements IDefaultView {

    @Override
    public void show() {
        User userSession = Router.getUserSession();
        
        if (userSession.getRole().equals("patient")) {
            Patient patient = (Patient) userSession;
            
            new Banner("PATIENT INFORMATION").render();
            
            System.out.println("* Account Information:");
            System.out.printf("[]: %s \n", patient.getUsername());
            System.out.printf("[]: %s \n", patient.getPassword());
            
            System.out.println("* Personal Information:");
            System.out.printf("[FIRST NAME]: %s \n", patient.getFirstName());
            System.out.printf("[LAST NAME]: %s \n", patient.getLastName());
            System.out.printf("[ADDRESS]: %s \n", patient.getAddress());
            System.out.printf("[CONTACT]: %s \n", patient.getContact());
            System.out.printf("[SEX]: %s \n", patient.getSex());
            System.out.printf("[BLOOD TYPE]: %s \n", patient.getBloodType());
            System.out.printf("[INITIAL DIAGNOSIS]: %s \n", patient.getInitialDiagnosis());
            System.out.printf("[RELEASED]: %s \n", patient.isReleased());
        }
        
        new Halter().render();
        Router.navigate("patient-dashboard");
    }
    
}
