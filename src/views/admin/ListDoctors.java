package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import layouts.Banner;
import layouts.Halter;
import models.Doctor;
import models.User;
import routes.Router;

public class ListDoctors implements IDefaultView {
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();
    
    private void listDoctors(ArrayList<User> doctors) {
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","DEPARTMENT");
        for(User user : doctors){
            Doctor doctor = (Doctor) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", doctor.getId(), doctor.getUsername(), doctor.getFirstName(), doctor.getLastName(), doctor.getAddress(), doctor.getContact(), doctor.getDepartment());
        }
        System.out.println(fmt);
    }

    @Override
    public void show() {
        ArrayList<User> doctors = Admin.listDoctors();
        
        if (doctors.isEmpty()) {
             new Banner("NO DOCTORS FOUND.").render();
        } else this.listDoctors(doctors);
        
        halter.render();
        Router.navigate("admin-dashboard");
    }

}
