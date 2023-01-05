package models;

import interfaces.IModel;
import java.util.UUID;

public class User implements IModel {
    private String id;
    private String username;
    private String password;
    private String role;
    
    public User(String username, String password, String role) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return role;
    }
    
    @Override
    public String getId() {
        return this.id;
    }
}
