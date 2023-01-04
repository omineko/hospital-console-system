package routes;

import interfaces.IDefaultView;
import interfaces.IRoute;

public class Route implements IRoute {
    private IDefaultView view;
    private String name;
    
    public Route(String name, IDefaultView view) {
        this.view = view;
        this.name = name;
    }
    
    @Override
    public void navigate() {
        this.view.show();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
