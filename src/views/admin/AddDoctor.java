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
import views.Enums.Department;

public class AddDoctor implements IDefaultView {
    private HashMap<String, String> data = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void show() {
        try {
            System.out.println("-- ADD DOCTOR --");

            System.out.println("* Account Information:");
            data.put("username", new Field("New Username").renderAndReturn());
            data.put("password", new Field("New Password").renderAndReturn());

            System.out.println("* Personal Information:");
            data.put("first-name", new Field("First Name").renderAndReturn());
            data.put("last-name", new Field("Last Name").renderAndReturn());
            data.put("address", new Field("Address").renderAndReturn());
            data.put("contact", new Field("Contact", true).renderAndReturn());
            data.put("department", this.displayDepartment());
            this.displayConfirmation();
            
        } catch (Exception e) {
            System.out.println("Invalid Input. Doctor not saved. Reverting..");
            Router.navigate("admin-dashboard");
        }
    }
    
    private void displayConfirmation() {
        // review information
        new Banner(false, "Review Information").render();
        
        System.out.println("* Account Information:");
        System.out.printf("[%s]: %s \n", "USERNAME", data.get("username"));
        System.out.printf("[%s]: %s \n", "PASSWORD", data.get("password"));
        System.out.println("* Personal Information:");
        System.out.printf("[%s]: %s \n", "FIRST NAME", data.get("first-name"));
        System.out.printf("[%s]: %s \n", "LAST NAME", data.get("last-name"));
        System.out.printf("[%s]: %s \n", "ADDRESS", data.get("address"));
        System.out.printf("[%s]: %s \n", "CONTACT", data.get("contact"));
        System.out.printf("[%s]: %s \n", "DEPARTMENT", data.get("department"));
        
        // confirm
        System.out.println("Are you sure the details were correct? [Y]");
        scanner.nextLine();
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            this.save();
        } else {
            System.out.println("Doctor profile not save. Aborting...");
            this.show();
        }
    }
    
    private String displayDepartment() {
        Department[] departments = Department.values();
        int count = 1;
        
        System.out.println("Department: ");
        
        for (Department department : departments) {
            System.out.println("[" + count + "] -> " + department);
            count++;
        }
        
        System.out.print("Choose Department: ");
        int choice = scanner.nextInt() - 1;
        
        if (choice < 0 || choice >= departments.length) {
            count = 1;
            System.out.println("Invalid Choice. Try Again");
            this.displayDepartment();
        }
        
        return departments[choice].toString();
    }
    
    private void save() {
        ArrayList<HashMap<String, String>> errors = Admin.addDoctor(data);
        
        if (!errors.isEmpty()) {
            new Banner(false, "Errors Detected. Not Saved.").render();
            new DisplayError(errors).render();
            this.show();
        } else {
            System.out.println("Doctor Profile Saved.");
            Router.navigate("go-back");
        }
    }

}
