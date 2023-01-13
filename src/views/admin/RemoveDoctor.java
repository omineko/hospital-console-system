package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.DisplayError;
import layouts.Field;
import layouts.Halter;
import models.Doctor;
import routes.Router;


public class RemoveDoctor implements IDefaultView {
    private String id;
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();

    @Override
    public void show() {
        new Banner(false, "REMOVE DOCTOR").render();
        boolean isDoctorsExist = Router.peek("list-doctors");
        
        if (isDoctorsExist) {
            this.id = new Field("Enter Doctor ID: ").renderAndReturn();
            this.displayConfirmation(); 
        }
        
        halter.render();
        Router.navigate("admin-dashboard");
    }
    
    private void displayConfirmation() {
        System.out.println("This is an irreversable action. Delete the following user:");
        
        this.displayDoctor();
        
        System.out.println("Proceed? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            ArrayList<HashMap<String, String>> errors = Admin.removeDoctor(this.id);
            
            if (errors.isEmpty()) {
                System.out.println("Doctor removed.");
            } else {
                new Banner(false, "Errors detected. Not saved.").render();
                new DisplayError(errors).render();
            }
        } else {
            System.out.println("Action aborted.");
        }
    }
    
    private void displayDoctor() {
        Doctor doctor = Admin.findDoctor(this.id);
        
        if (doctor != null) {
           Formatter fmt = new Formatter();  
           fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","DEPARTMENT");
           fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", doctor.getId(), doctor.getUsername(), doctor.getFirstName(), doctor.getLastName(), doctor.getAddress(), doctor.getContact(), doctor.getDepartment());
           System.out.println(fmt);
        } else {
            new Banner("NO DOCTORS SELECTED").render();
        }
    }

}
