

package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.Formatter;
import java.util.Scanner;
import layouts.Banner;
import models.User;
import routes.Router;


public class RemoveReceptionist implements IDefaultView {
    private String id;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        new Banner(false, "Remove Receptionist").render();
        Router.navigate("list-receptionists");
        
        System.out.print("Enter Receptionist ID: ");
        this.id = scanner.nextLine();
        
        this.displayConfirmation();
    }
    
    private void displayConfirmation() {
        System.out.println("This is an irreversable action. Delete the following user:");
        
        this.displayReceptionist();
        
        System.out.println("Proceed? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            boolean isSuccess = Admin.removeReceptionist(this.id);
            
            if (isSuccess) {
                System.out.println("Receptionist removed");
            } else {
                System.out.println("ID not found. Please try again.");
            }
        } else {
            System.out.println("Action aborted.");
            this.show();
        }
    }
    
    private void displayReceptionist() {
        User receptionist = Admin.findReceptionist(this.id);
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s \n", "ID", "USERNAME");
        fmt.format("%15s %15s \n", receptionist.getId(), receptionist.getUsername());
        System.out.println(fmt);
    }


}
