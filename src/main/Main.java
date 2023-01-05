package main;

import routes.Router;
import database.Users;

public class Main extends Router {
    
    public static void main(String[] args) {
        Users users = new Users();
        
        users.seed();
        init();
        navigate("main-menu");
    }
}
