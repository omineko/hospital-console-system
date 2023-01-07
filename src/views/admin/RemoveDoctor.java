

package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.Formatter;
import java.util.Scanner;
import layouts.Banner;
import layouts.Field;
import models.Doctor;
import routes.Router;


public class RemoveDoctor implements IDefaultView {
    private String id;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        new Banner(false, "Remove Doctor").render();
        Router.navigate("list-doctors");
        
        this.id = new Field("Enter Doctor ID: ").renderAndReturn();
        
        this.displayConfirmation();
    }
    
    private void displayConfirmation() {
        System.out.println("This is an irreversable action. Delete the following user:");
        
        this.displayDoctor();
        
        System.out.println("Proceed? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            boolean isSuccess = Admin.removeDoctor(this.id);
            
            if (isSuccess) {
                System.out.println("Doctor removed");
                Router.navigate("go-back");
            } else {
                System.out.println("ID not found. Please try again.");
            }
        } else {
            System.out.println("Action aborted.");
            this.show();
        }
    }
    
    private void displayDoctor() {
        Doctor doctor = Admin.findDoctor(this.id);
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","DEPARTMENT");
        fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", doctor.getId(), doctor.getUsername(), doctor.getFirstName(), doctor.getLastName(), doctor.getAddress(), doctor.getContact(), doctor.getDepartment());
        System.out.println(fmt);
    }

}
