package com.example.se;

public class User {
    String name;
    int id;
    String password;
    String email;
    int penalty_info; // 패널티 여부(?)
    int userID;
    static int user_count; //사용자의 수를 누적하는 변수


    public User(String name, int id, String password, String email, int penalty_info, int userID, int user_count) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.penalty_info = penalty_info;
        this.userID = userID;
        this.user_count = user_count;
    }
    int getUserID(int userID) {return userID;}
}