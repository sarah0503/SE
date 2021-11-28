package com.example.se;

public class Reservation {
    // 버스아이디, 출발지, 도착지, 출발시간
    public static int count = 0;
    private int busId;
    private int userId;
    private int reservationId;
    private int time;
    private String arrival;
    private String departure;

    Reservation(){
        reservationId = count;
        count ++;
    }

    //Reservation_check 에 사용할 생성자
    Reservation(int busId, String arrival, String departure, int time){
        this.busId = busId;
        this.arrival = arrival;
        this.departure = departure;
        this.time = time;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getBusId() {
        return busId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

}
