package com.example.se;

public class Manager {
    String name;
    String password;
    String email;
    String managerID;
    public Manager(){}
    public Manager(String name, String password, String email, String managerID) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.managerID = managerID;
    }

    void setName(String name){this.name = name;}
    String getName(){return this.name;}
    void setPassword(String password){this.password = password;}
    String getPassword(){return this.password;}
    void setEmail(String email){this.email = email;}
    String getEmail(){return this.email;}
    void setManagerID(String managerID){this.managerID = managerID;}
    String getManagerID(){return this.managerID;}
}
