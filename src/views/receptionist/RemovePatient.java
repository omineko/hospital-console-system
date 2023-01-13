package views.receptionist;

import controllers.Admin;
import controllers.Receptionist;
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
import models.User;
import routes.Router;

public class RemovePatient implements IDefaultView {
    private String id;
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();

    @Override
    public void show() {
        new Banner(false, "Remove Patient").render();
        boolean isPatientsExists = Router.peek("list-patients");
        
        if (isPatientsExists) {
            this.id = new Field("Enter Patient ID: ").renderAndReturn();
            this.displayConfirmation(); 
        }
        
        halter.render();
        Router.navigate("receptionist-dashboard");
    }
    
    private void displayConfirmation() {
        System.out.println("This is an irreversable action. Delete the following user:");
        
        this.displayPatient();
        
        System.out.println("Proceed? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            ArrayList<HashMap<String, String>> errors = Receptionist.removePatient(this.id);
            
            if (errors.isEmpty()) {
                System.out.println("Patient removed.");
            } else {
                new Banner(false, "Errors detected. Not saved.").render();
                new DisplayError(errors).render();
            }
        } else {
            System.out.println("Action aborted.");
        }
    }
    
    private void displayPatient() {
        Patient patient = Receptionist.findPatient(this.id);
        
        if (patient != null) {
            Formatter fmt = new Formatter();  
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","SEX", "BLOOD TYPE", "INITIAL DIAGNOSIS");
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", patient.getId(), patient.getUsername(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getContact(), patient.getSex(), patient.getBloodType(), patient.getInitialDiagnosis());
            System.out.println(fmt);
        } else {
            new Banner("NO RECEPTIONISTS SELECTED").render();
        }
    }

}
