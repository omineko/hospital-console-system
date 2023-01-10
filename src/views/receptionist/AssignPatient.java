package views.receptionist;

import controllers.Admin;
import controllers.Receptionist;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import layouts.Field;
import models.Doctor;
import models.Patient;
import models.User;

public class AssignPatient implements IDefaultView {
    private String patientId, doctorId;
    
    @Override
    public void show() {
        this.listPatients();
        
        this.doctorId = new Field("Enter Patient ID: ").renderAndReturn();
        
        this.listDoctors();
        
        System.out.println("Assign to which doctor?");
        this.doctorId = new Field("Enter Doctor ID: ").renderAndReturn();
    }
    
    private void listPatients() {
        ArrayList<User> patients = Receptionist.listPatients();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","SEX", "BLOOD TYPE", "INITIAL DIAGNOSIS");
        for(User user : patients){
            Patient patient = (Patient) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s \n", patient.getId(), patient.getUsername(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getContact(), patient.getSex(), patient.getBloodType(), patient.getInitialDiagnosis());
        }
        System.out.println(fmt);
    }
    
    private void listDoctors() {
        ArrayList<User> doctors = Receptionist.listDoctors();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","DEPARTMENT");
        for(User user : doctors){
            Doctor doctor = (Doctor) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", doctor.getId(), doctor.getUsername(), doctor.getFirstName(), doctor.getLastName(), doctor.getAddress(), doctor.getContact(), doctor.getDepartment());
        }
        System.out.println(fmt);
    }
}
