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
import models.User;
import routes.Router;


public class RemoveAdmin implements IDefaultView {
    private String id;
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();

    @Override
    public void show() {
        new Banner(false, "REMOVE ADMIN").render();
        boolean isAdminsExist = Router.peek("list-admins");
        
        if (isAdminsExist) {
            this.id = new Field("Enter Admin ID: ").renderAndReturn();
            this.displayConfirmation(); 
        }
        
        halter.render();
        Router.navigate("admin-dashboard");
    }
    
    private void displayConfirmation() {
        System.out.println("This is an irreversable action. Delete the following user:");
        
        this.displayAdmin();
        
        System.out.println("Proceed? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            ArrayList<HashMap<String, String>> errors = Admin.removeAdmin(this.id);
            
            if (errors.isEmpty()) {
                System.out.println("Admin removed.");
            } else {
                new Banner(false, "Errors detected. Not saved.").render();
                new DisplayError(errors).render();
            }
        } else {
            System.out.println("Action aborted.");
        }
        
        halter.render();
        Router.navigate("admin-dashboard");
    }
    
    private void displayAdmin() {
        User admin = Admin.findAdmin(this.id);
        
        if (admin != null) {
            Formatter fmt = new Formatter();  
            fmt.format("%15s %15s \n", "ID", "USERNAME");
            fmt.format("%15s %15s \n", admin.getId(), admin.getUsername());
            System.out.println(fmt);
        } else {
            new Banner("NO ADMINS SELECTED").render();
        }
    }

}
