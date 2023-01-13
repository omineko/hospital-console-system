package views.doctor;

import controllers.Doctor;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.DisplayError;
import layouts.Field;
import layouts.Halter;
import models.Patient;
import routes.Router;

public class ReleasePatient implements IDefaultView {
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();
    private String patientId;

   @Override
    public void show() {
        new Banner(false, "RELEASE PATIENT").render();
        boolean isPatientsExists = Router.peek("list-patients@doctor");
        
        if (isPatientsExists) {
            this.patientId = new Field("Enter Patient ID: ").renderAndReturn();
            this.displayConfirmation();
        }
        
        halter.render();
        Router.navigate("doctor-dashboard");
    }
    
    private void displayConfirmation() {
        System.out.println("This is an irreversable action. Release the following patient:");
        
        this.displayPatient();
        
        System.out.println("Proceed? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            ArrayList<HashMap<String, String>> errors = Doctor.releasePatient(this.patientId);
            
            if (errors.isEmpty()) {
                System.out.println("Patient is released.");
            } else {
                new Banner(false, "Errors detected. Not released.").render();
                new DisplayError(errors).render();
            }
        } else {
            System.out.println("Action aborted.");
        }
    }
    
    private void displayPatient() {
        Patient patient = Doctor.findPatient(this.patientId);
        
        if (patient != null) {
            Formatter fmt = new Formatter();  
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","SEX", "BLOOD TYPE", "INITIAL DIAGNOSIS", "RELEASED");
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s \n", patient.getId(), patient.getUsername(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getContact(), patient.getSex(), patient.getBloodType(), patient.getInitialDiagnosis(), patient.isReleased());
            System.out.println(fmt);
        } else {
            new Banner("NO PATIENT SELECTED").render();
        }

    }
}
