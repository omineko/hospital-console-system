package views.receptionist;

import controllers.Admin;
import controllers.Receptionist;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.DisplayError;
import layouts.Field;
import models.Doctor;
import models.Patient;
import models.User;
import routes.Router;

public class AssignPatient implements IDefaultView {
    private String patientId, doctorId;
    private ArrayList<User> patients = Receptionist.listPatients();
    private ArrayList<User> doctors = Receptionist.listDoctors();
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void show() {
        this.listPatients();
        
        this.doctorId = new Field("Enter Patient ID: ").renderAndReturn();
        
        this.listDoctors();
        
        System.out.println("Assign to which doctor?");
        this.doctorId = new Field("Enter Doctor ID: ").renderAndReturn();
        this.displayConfirmation();
    }
    
    private void displayConfirmation() {
        
        // confirm
        System.out.println("Are you sure the details were correct? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            this.save();
        } else {
            System.out.println("Patient profile not save. Aborting...");
            this.show();
        }
    }
    
    private void save() {
        ArrayList<HashMap<String, String>> errors = Receptionist.assignPatient(doctorId, patientId);
        
        if (!errors.isEmpty()) {
            new Banner(false, "Errors Detected. Not Saved.").render();
            new DisplayError(errors).render();
            this.show();
        } else {
            System.out.println("Patient Assigned Successfully.");
            Router.navigate("go-back");
        }
    }
    
    private void listPatients() {
        this.patients = Receptionist.listPatients();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","SEX", "BLOOD TYPE", "INITIAL DIAGNOSIS");
        for(User user : this.patients){
            Patient patient = (Patient) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", patient.getId(), patient.getUsername(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getContact(), patient.getSex(), patient.getBloodType(), patient.getInitialDiagnosis());
        }
        System.out.println(fmt);
    }
    
    private void listDoctors() {
        this.doctors = Receptionist.listDoctors();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","DEPARTMENT");
        for(User user : this.doctors){
            Doctor doctor = (Doctor) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", doctor.getId(), doctor.getUsername(), doctor.getFirstName(), doctor.getLastName(), doctor.getAddress(), doctor.getContact(), doctor.getDepartment());
        }
        System.out.println(fmt);
    }
}
