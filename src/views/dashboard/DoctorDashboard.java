package views.dashboard;

import interfaces.IDefaultView;
import java.util.PriorityQueue;
import layouts.Banner;
import layouts.Choice;

public class DoctorDashboard implements IDefaultView {
    private PriorityQueue<String> selectedRoutes = new PriorityQueue<>();
    
    public DoctorDashboard() {
        selectedRoutes.add("list-patients@doctor");
        selectedRoutes.add("release-patient");
        selectedRoutes.add("sign-out");
    }
    
    @Override
    public void show() {
        Banner banner = new Banner("Doctor Dashboard");
        Choice choice = new Choice(selectedRoutes);
        
        banner.render();
        choice.render();
    }
}
