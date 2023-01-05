package models;

import java.util.UUID;

public class User {
    private String id;
    private String username;
    private String password;
    
    public User(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }
    
    public String getId() {
        return this.id;
    }
}
