

package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.Formatter;
import java.util.Scanner;
import layouts.Banner;
import layouts.Field;
import models.User;
import routes.Router;


public class RemoveAdmin implements IDefaultView {
    private String id;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        new Banner(false, "Remove Admin").render();
        Router.navigate("list-admins");
        
        this.id = new Field("Enter Admin ID: ").renderAndReturn();
        
        this.displayConfirmation();
    }
    
    private void displayConfirmation() {
        System.out.println("This is an irreversable action. Delete the following user:");
        
        this.displayAdmin();
        
        System.out.println("Proceed? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            boolean isSuccess = Admin.removeAdmin(this.id);
            
            if (isSuccess) {
                System.out.println("Admin removed");
                Router.navigate("go-back");
            } else {
                System.out.println("ID not found. Please try again.");
            }
        } else {
            System.out.println("Action aborted.");
            this.show();
        }
    }
    
    private void displayAdmin() {
        User admin = Admin.findAdmin(this.id);
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s \n", "ID", "USERNAME");
        fmt.format("%15s %15s \n", admin.getId(), admin.getUsername());
        System.out.println(fmt);
    }

}
