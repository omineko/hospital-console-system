

package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.DisplayError;
import layouts.Field;
import routes.Router;

public class AddReceptionist implements IDefaultView {
    HashMap<String, String> data = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        System.out.println("-- ADD RECEPTIONIST --");
        
        System.out.println("* Account Information:");
        data.put("username", new Field("New Username").renderAndReturn());
        data.put("password", new Field("New Password").renderAndReturn());
        
        this.displayConfirmation();
    }
    
    public void save() {

        ArrayList<HashMap<String, String>> errors = Admin.addReceptionist(data);
        
        if (!errors.isEmpty()) {
            new Banner(false, "Errors Detected. Not Saved.").render();
            new DisplayError(errors).render();
            this.show();
        } else {
            System.out.println("Recptionist Profile Saved.");
            Router.navigate("go-back");
        }
    }
    
    private void displayConfirmation() {
        // review information
        new Banner(false, "Review Information").render();
        
        System.out.printf("[%s]: %s \n", "USERNAME", data.get("username"));
        System.out.printf("[%s]: %s \n", "PASSWORD", data.get("password"));
        
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
