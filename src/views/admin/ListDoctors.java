

package views.admin;

import controllers.Admin;
import interfaces.IDefaultView;
import java.util.ArrayList;
import java.util.Formatter;
import models.Doctor;
import models.User;

public class ListDoctors implements IDefaultView {

    @Override
    public void show() {
        ArrayList<User> doctors = Admin.listDoctors();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", "ID", "USERNAME", "FIRST NAME", "LAST NAME", "ADDRESS","CONTACT","DEPARTMENT");
        for(User user : doctors){
            Doctor doctor = (Doctor) user;
            fmt.format("%15s %15s %15s %15s %15s %15s %15s \n", doctor.getId(), doctor.getUsername(), doctor.getFirstName(), doctor.getLastName(), doctor.getAddress(), doctor.getContact(), doctor.getDepartment());
        }
        System.out.println(fmt);
    }

}
