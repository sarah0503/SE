package com.example.se;

public class Penalty {
    int penalty_count=0;        // 사용자의 시작 penalty_count 는 0이다.

//    Penalty(){
//        penalty_count = 0;
//    }

    public void setPenaltyCount(int penalty_count){this.penalty_count = penalty_count;}
    public int getPenaltyCount(){return this.penalty_count;}
}