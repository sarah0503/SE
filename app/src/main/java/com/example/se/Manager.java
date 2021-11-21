package com.example.se;

public class Manager {
    String name;
    int id;
    String password;
    String email;
    int managerID;
    //static int manager_count = 0; //관리자의 수를 누적하는 변수
    //임시 생성자
    public Manager(){}
    public Manager(String name, int id, String password, String email, int managerID) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.managerID = managerID;
        //manager_count ++;
    }

    void setName(String name){this.name = name;}
    String getName(){return this.name;}
    void setId(int id){this.id = id;}
    int getId(){return this.id;}
    void getPassword(String password){this.password = password;}
    String getPassword(){return this.password;}
    void setEmail(String email){this.email = email;}
    String getEmail(){return this.email;}
    void setManagerID(int managerID){this.managerID = managerID;}
    int getManagerID(){return this.managerID;}
    //void setManagerCount(int manager_count){this.manager_count = manager_count;}
    //int getManagerCount(){return this.manager_count;}
}
