package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
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
            System.out.print("New Username: ");
            data.put("username", scanner.nextLine());
            System.out.print("New Password: ");
            data.put("password", scanner.nextLine());

            System.out.println("* Personal Information:");
            System.out.print("First Name: ");
            data.put("first-name", scanner.nextLine());
            System.out.print("Last Name: ");
            data.put("last-name", scanner.nextLine());
            System.out.println("Address: ");
            data.put("address", scanner.nextLine());
            System.out.print("Contact No.: ");
            data.put("contact", String.valueOf(scanner.nextInt()));
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
        
        data.forEach((key, value) -> {
            System.out.printf("[%s]: %s \n", key, value);
        });
        
        // confirm
        System.out.println("Are you sure the details were correct? [Y]");
        scanner.nextLine();
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            this.save();
        } else {
            System.out.println("Doctor profile not save. Retrying...");
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
        HashMap<String, String> result = Admin.addDoctor(data);
        
        if (!Boolean.valueOf(result.get("status"))) {
            new Banner(false, "Errors Detected. Not Saved.").render();
            
            this.show();
        } else {
            System.out.println("Doctor Profile Saved.");
            Router.navigate("main-menu");
        }
    }

}
