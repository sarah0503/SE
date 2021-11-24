package com.example.se;

public class Waiting {
    public static int count = 0;
    private int busId;
    private int userId;
    private int waitingId;
    private int time;
    private int waitingCount;
    private String arrival;
    private String departure;

    Waiting(){
        waitingId = count;
        count ++;
    }

    public void setWaitingCount(int waitingCount) {
        this.waitingCount = waitingCount;
    }

    public int getWaitingCount() {
        return waitingCount;
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

    public int getWaitingId() {
        return waitingId;
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

