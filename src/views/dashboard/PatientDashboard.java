package views.dashboard;

import interfaces.IDefaultView;
import java.util.PriorityQueue;
import layouts.Banner;
import layouts.Choice;

public class PatientDashboard implements IDefaultView {
    private PriorityQueue<String> selectedRoutes = new PriorityQueue<>();
    
    public PatientDashboard() {
        selectedRoutes.add("view-information");
        selectedRoutes.add("sign-out");
    }
    
    @Override
    public void show() {
        Banner banner = new Banner("Patient Dashboard");
        Choice choice = new Choice(selectedRoutes);
        
        banner.render();
        choice.render();
    }
}
