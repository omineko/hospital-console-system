package routes;

import interfaces.IDefaultView;
import interfaces.IRoute;

// Defines the Route class

public class Route implements IRoute {
    private IDefaultView view;
    private String name;
    
    public Route(String name, IDefaultView view) {
        this.view = view;
        this.name = name;
    }
    
    @Override
    public String navigate() {
        this.view.show();
        
        return this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
