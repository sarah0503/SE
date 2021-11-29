package com.example.se;

public class Bookmark {
    Boolean bookmark_on;    //DB 에서 북마크 정보 가져와야함
    private int userID;             //DB 에서 userID가 bookmark_on = True 인 것의 정보를 모두 가져와야해서 필요
    private int busId;
    private int time;
    private String arrival;
    private String departure;

    public Bookmark(int busId, int time, String arrival, String departure) {
        this.busId = busId;
        this.time = time;
        this.arrival = arrival;
        this.departure = departure;
    }

    void setBookmark(boolean bookmark_on){this.bookmark_on = bookmark_on;}
    Boolean getBookmark(){return this.bookmark_on;}
    void setUserID(int userID) { this.userID = userID; }
    int getUserID() { return userID; }
    public void setBusId(int busId) {
        this.busId = busId;
    }
    public int getBusId() {
        return busId;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public int getTime(){
        return time;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    public String getArrival() {
        return arrival;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    public String getDeparture() {
        return departure;
    }
}