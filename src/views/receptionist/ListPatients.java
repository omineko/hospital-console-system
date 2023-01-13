package views.receptionist;

import controllers.Admin;
import controllers.Receptionist;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import layouts.Banner;
import layouts.Halter;
import models.Patient;
import models.User;
import routes.Router;

public class ListPatients implements IDefaultView {
    private Scanner scanner = new Scanner(System.in);
    private Halter halter = new Halter();
    
    private void listPatients(ArrayList<User> patients) {
        new Banner(false, "PATIENTS LIST").render();
        
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","SEX", "BLOOD TYPE", "INITIAL DIAGNOSIS", "RELEASED");
        for(User user : patients){
            Patient patient = (Patient) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s \n", patient.getId(), patient.getUsername(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getContact(), patient.getSex(), patient.getBloodType(), patient.getInitialDiagnosis(), patient.isReleased());
        }
        System.out.println(fmt);
    }
    
    @Override
    public boolean peek() {
        ArrayList<User> patients = Receptionist.listPatients();
        
        if (patients.isEmpty()) {
             new Banner("NO PATIENTS FOUND.").render();
        } else this.listPatients(patients);
        
        return !patients.isEmpty();
    }

    @Override
    public void show() {
        this.peek();
        
        halter.render();
        Router.navigate("receptionist-dashboard");
    }
}
