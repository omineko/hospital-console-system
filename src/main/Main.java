package main;

import routes.Router;
import database.Users;
import static routes.Router.init;
import static routes.Router.navigate;

public class Main extends Router {
    
    public static void main(String[] args) {
        Users users = new Users();
        
        users.seed();
        init();
        navigate("main-menu");
    }
}
