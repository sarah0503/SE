package com.example.se;

public class Reservation {
    public static int count = 0;
    private int busId;
    private int userId;
    private int reservationId;
    private int time;
    private String place;

    Reservation(){
        reservationId = count;
        count ++;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
