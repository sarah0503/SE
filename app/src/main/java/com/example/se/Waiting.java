package com.example.se;

public class Waiting {
    private int busId;
    private int userId;
    private int waitingId;
    private static int count = 0;

    Waiting(){
        waitingId = count;
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

    public int getWaitingId() {
        return waitingId;
    }
}
