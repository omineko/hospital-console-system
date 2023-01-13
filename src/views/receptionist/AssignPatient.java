package views.receptionist;

import controllers.Receptionist;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;
import layouts.Banner;
import layouts.DisplayError;
import layouts.Field;
import layouts.Halter;
import models.Doctor;
import models.Patient;
import models.User;
import routes.Router;

public class AssignPatient implements IDefaultView {
    private Scanner scanner = new Scanner(System.in);
    private String patientId, doctorId;
    private Halter halter = new Halter();
    
    @Override
    public void show() {
        ArrayList<User> patients = Receptionist.listPatients();
        ArrayList<User> doctors = Receptionist.listDoctors();
        
        if (patients.isEmpty() || doctors.isEmpty()) {
            new Banner("NO PATIENT OR DOCTOR LISTED.").render();
        } else {
            this.listPatients(patients);
            this.patientId = new Field("Enter Patient ID: ").renderAndReturn();

            this.listDoctors(doctors);
            System.out.println("Assign to which doctor?");
            this.doctorId = new Field("Enter Doctor ID: ").renderAndReturn();

            this.displayConfirmation();
        }
        
        halter.render();
        Router.navigate("receptionist-dashboard");
    }
    
    private void displayConfirmation() {
        Patient patient = Receptionist.findPatient(this.patientId);
        Doctor doctor = Receptionist.findDoctor(this.doctorId);
        
        if ((patient != null) && (doctor != null)) {
            System.out.printf("Assign Patient %s to Dr. %s %s \n", patient.getLastName(), doctor.getFirstName(), doctor.getLastName());
        } else {
            new Banner("INVALID PATIENT OR DOCTOR ID. NONE SELECTED").render();
        }
        
        // confirm
        System.out.println("Are you sure the details were correct? [Y]");
        String choice = scanner.nextLine();
        
        if (choice.toUpperCase().equals("Y")) {
            this.save();
        } else {
            System.out.println("Patient not assigned. Aborting...");
        }
    }
    
    private void save() {
        ArrayList<HashMap<String, String>> errors = Receptionist.assignPatient(doctorId, patientId);
        
        if (!errors.isEmpty()) {
            new Banner(false, "Errors Detected. Not Saved.").render();
            new DisplayError(errors).render();
        } else {
            System.out.println("Patient Assigned Successfully.");
        }
    }
    
    private void listPatients(ArrayList<User> patients) {
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","SEX", "BLOOD TYPE", "INITIAL DIAGNOSIS", "RELEASED");
        for(User user : patients){
            Patient patient = (Patient) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s \n", patient.getId(), patient.getUsername(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getContact(), patient.getSex(), patient.getBloodType(), patient.getInitialDiagnosis(), patient.isReleased());
        }
        System.out.println(fmt);
    }
    
    private void listDoctors(ArrayList<User> doctors) {
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","DEPARTMENT");
        for(User user : doctors){
            Doctor doctor = (Doctor) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", doctor.getId(), doctor.getUsername(), doctor.getFirstName(), doctor.getLastName(), doctor.getAddress(), doctor.getContact(), doctor.getDepartment());
        }
        System.out.println(fmt);
    }
}
