package com.example.se;

import java.util.List;

public class User {
    String name;
    int id;
    String password;
    String email;
    int penalty_info; // 패널티 여부(?)
    int userID;
    public static int user_count = 0; //사용자의 수를 누적하는 변수
//    Waiting waitings[];
//    Reservation reservations[];
    //임시 생성자
    public User(){}
    public User(String name, int id, String password, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.penalty_info = penalty_info;
        this.userID = user_count;
        user_count ++;
    }

    void setName(String name){this.name = name;}
    String getName(){return this.name;}
    void setId(int id){this.id = id;}
    int getId(){return this.id;}
    void getPassword(String password){this.password = password;}
    String getPassword(){return this.password;}
    void setEmail(String email){this.email = email;}
    String getEmail(){return this.email;}
    void setPenalty(int penalty_info){this.penalty_info = penalty_info;}
    int getPenalty(){return this.penalty_info;}
    void setUserID(int userID){this.userID = userID;}
    int getUserID(){return this.userID;}
    void setUserCount(int user_count){this.user_count = user_count;}
    int getUserCount(){return this.user_count;}

    public boolean checkId(String id){
        if(id.equals(this.id)) return true;
        else return  false;
    }

    public boolean isCorrect(String pw){
        if(pw.equals(this.password)) return true;
        else return  false;
    }
}