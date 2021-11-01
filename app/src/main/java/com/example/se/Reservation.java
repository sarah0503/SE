package com.example.se;

public class Reservation {
    private int busId;
    private int userId;
    private int reservationId;
    private static int count = 0;

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
}
