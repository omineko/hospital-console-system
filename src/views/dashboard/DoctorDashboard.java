package views.dashboard;

import interfaces.IDefaultView;
import java.util.ArrayList;
import layouts.Banner;
import layouts.Choice;

public class DoctorDashboard implements IDefaultView {
    private ArrayList<String> selectedRoutes = new ArrayList<>();
    
    public DoctorDashboard() {
        selectedRoutes.add("admin-login");
        selectedRoutes.add("doctor-login");
        selectedRoutes.add("patient-login");
        selectedRoutes.add("receptionist-login");
    }
    
    @Override
    public void show() {
        Banner banner = new Banner("Apple Lake Hospital");
        Choice choice = new Choice(selectedRoutes);
        
        banner.render();
        choice.render();
    }
}
