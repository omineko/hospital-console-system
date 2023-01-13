package views.dashboard;

import interfaces.IDefaultView;
import java.util.PriorityQueue;
import layouts.Banner;
import layouts.Choice;

public class ReceptionistDashboard implements IDefaultView {
    private PriorityQueue<String> selectedRoutes = new PriorityQueue<>();
    
    public ReceptionistDashboard() {
        selectedRoutes.add("add-patient");
        selectedRoutes.add("list-patients");
        selectedRoutes.add("assign-patient");
        selectedRoutes.add("remove-patient");
        selectedRoutes.add("sign-out");
    }
    
    @Override
    public void show() {
        Banner banner = new Banner("Receptionist Dashboard");
        Choice choice = new Choice(selectedRoutes);
        
        banner.render();
        choice.render();
    }
}
