package com.plemiannyk.procrastination;

import java.util.HashMap;

public class User extends Database {
    private int id;
    private String login;
    private String password;


    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String setLogin(String login) {
        this.login = login;
        return  login;
    }

}
