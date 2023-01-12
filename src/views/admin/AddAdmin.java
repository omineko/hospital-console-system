package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.DisplayError;
import layouts.Field;
import layouts.Halter;
import routes.Router;

public class AddAdmin implements IDefaultView {
    private HashMap<String, String> data = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();

    @Override
    public void show() {
        new Banner(false, "ADD ADMIN").render();
        
        System.out.println("* Account Information:");
        data.put("username", new Field("New Username").renderAndReturn());
        data.put("password", new Field("New Password").renderAndReturn());
        
        this.displayConfirmation();
    }
    
    public void save() {
        ArrayList<HashMap<String, String>> errors = Admin.addAdmin(data);
        
        if (!errors.isEmpty()) {
            new Banner(false, "Errors Detected. Not Saved.").render();
            new DisplayError(errors).render();
        } else {
            System.out.println("Admin Profile Saved.");
        }
    }
    
    private void displayConfirmation() {
        // review information
        new Banner(false, "REVIEW INFORMATION").render();
        
        System.out.printf("[%s]: %s \n", "USERNAME", data.get("username"));
        System.out.printf("[%s]: %s \n", "PASSWORD", data.get("password"));
        
        // confirm
        System.out.println("Are you sure the details were correct? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            this.save();
        } else {
            System.out.println("Admin profile not save.");
        }

        halter.render();
        Router.navigate("admin-dashboard");
    }

}
