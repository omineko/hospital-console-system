

package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import routes.Router;

public class AddReceptionist implements IDefaultView {
    HashMap<String, String> data = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        System.out.println("-- ADD RECEPTIONIST --");
        
        System.out.println("* Account Information:");
        System.out.print("New Username: ");
        data.put("username", scanner.nextLine());
        System.out.print("New Password: ");
        data.put("password", scanner.nextLine());
        
        this.displayConfirmation();
    }
    
    public void save() {

        HashMap<String, String> result = Admin.addReceptionist(data);
        
        if (!Boolean.valueOf(result.get("status"))) {
            new Banner(false, "Errors Detected. Not Saved.").render();
            
            this.show();
        } else {
            System.out.println("Recptionist Profile Saved.");
            Router.navigate("main-menu");
        }
    }
    
    private void displayConfirmation() {
        // review information
        new Banner(false, "Review Information").render();
        
        data.forEach((key, value) -> {
            System.out.printf("[%s]: %s \n", key, value);
        });
        
        // confirm
        System.out.println("Are you sure the details were correct? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            this.save();
        } else {
            System.out.println("Receptionist profile not save. Retrying...");
            this.show();
        }
    }

}
