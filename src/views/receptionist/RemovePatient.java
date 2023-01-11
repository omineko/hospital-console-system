package views.receptionist;

import controllers.Admin;
import controllers.Receptionist;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import layouts.Banner;
import layouts.Field;
import models.Patient;
import models.User;
import routes.Router;

public class RemovePatient implements IDefaultView {
    private String id;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        new Banner(false, "Remove Patient").render();
        Router.navigate("list-doctors");
        
        this.id = new Field("Enter Patient ID: ").renderAndReturn();
        
        this.displayConfirmation();
    }
    
    private void displayConfirmation() {
        System.out.println("This is an irreversable action. Delete the following user:");
        
        this.displayPatient();
        
        System.out.println("Proceed? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            boolean isSuccess = Receptionist.removePatient(this.id);
            
            if (isSuccess) {
                System.out.println("Patient removed");
                Router.navigate("go-back");
            } else {
                System.out.println("ID not found. Please try again.");
            }
        } else {
            System.out.println("Action aborted.");
            this.show();
        }
    }
    
    private void displayPatient() {
        ArrayList<User> patients = Receptionist.listPatients();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","SEX", "BLOOD TYPE", "INITIAL DIAGNOSIS");
        for(User user : patients){
            Patient patient = (Patient) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", patient.getId(), patient.getUsername(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getContact(), patient.getSex(), patient.getBloodType(), patient.getInitialDiagnosis());
        }
        System.out.println(fmt);
        
        System.out.println("Press any to exit");
        scanner.nextLine();
    }

}
