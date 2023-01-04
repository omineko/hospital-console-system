package layouts;

import interfaces.IDefaultLayout;
import java.util.ArrayList;
import java.util.HashMap;
import routes.Route;
import routes.Router;

public class Choice implements IDefaultLayout {
    private HashMap<String, Route> routes;
    private ArrayList<String> selectedRoutes = new ArrayList<>();
    private int count = 1;
    
    public Choice(ArrayList<String> selectedRoutes) {
        this.selectedRoutes = selectedRoutes;
        this.routes = Router.getRoutes();
    }
    
    @Override
    public void render() {
        
        this.routes.forEach((key, route) -> {
            if (selectedRoutes.contains(key)) {
                System.out.println("[" + this.count + "] -> " + route.getName());
                this.count++;
            }
        });
    }

}
