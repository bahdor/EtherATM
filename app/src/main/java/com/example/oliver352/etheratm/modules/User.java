package com.example.oliver352.etheratm.modules;

/**
 * Created by Mingmin Bai on 9/25/2017.
 */

public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setEmail(String emal) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
