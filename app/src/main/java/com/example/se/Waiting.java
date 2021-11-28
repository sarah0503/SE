package com.example.se;

public class Waiting {
    // 대기 번호, 버스 아이디, 출발지, 도착지, 출발 시간
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

    //Waiting_check 에 사용할 생성자
    public Waiting(int busId, int time, int waitingCount, String arrival, String departure) {
        this.busId = busId;
        this.time = time;
        this.waitingCount = waitingCount;
        this.arrival = arrival;
        this.departure = departure;
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
