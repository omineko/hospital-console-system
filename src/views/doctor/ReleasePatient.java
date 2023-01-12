package views.doctor;

import controllers.Receptionist;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import models.Patient;
import models.User;
import routes.Router;

public class ReleasePatient implements IDefaultView {
    Scanner scanner = new Scanner(System.in);

    public void listPatients() {
        ArrayList<User> patients = Receptionist.listPatients();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","SEX", "BLOOD TYPE", "INITIAL DIAGNOSIS");
        for(User user : patients){
            Patient patient = (Patient) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", patient.getId(), patient.getUsername(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getContact(), patient.getSex(), patient.getBloodType(), patient.getInitialDiagnosis());
        }
        System.out.println(fmt);
    }

    @Override
    public void show() {
        this.listPatients();
        
        // releasepatient
    }
}
