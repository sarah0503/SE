package com.example.se;

public class Penalty {
    int userID;                 // 사용자 아이디를 찾아서 DB 에서 해당 아이디의 패널티 값을 변동해줘야함
    // 초기값 설정같은 느낌..?
    int penalty_count;          // 사용자의 시작 penalty_count 는 0이다.
    int penalty_date;           // 각 사용자마다 초기 penalty_date 값은 10;
    Boolean reservationBoolean; // 예약이 가능한지 아닌지, 가능하면 1, 아니면 0

    public void setUserID(int userID) { this.userID = userID; }
    public int getUserID() { return userID; }
    public void setPenaltyCount(int penalty_count){this.penalty_count = penalty_count;}
    public int getPenaltyCount(){return this.penalty_count;}
    public void setPenalty_date(int penalty_date) { this.penalty_date = penalty_date; }
    public int getPenalty_date() { return penalty_date; }
    public void setReservationBoolean(Boolean reservstionBoolean) { this.reservationBoolean = reservationBoolean; }
    public Boolean getReservationBoolean() { return reservationBoolean; }
}