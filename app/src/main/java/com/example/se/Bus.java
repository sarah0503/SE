package com.example.se;

public class Bus {
    static int count = 0;
    int id;
    String departure;
    String arrival;
    String stop1;
    String stop2;
    String stop3;

    public String getStop1() {
        return stop1;
    }

    public void setStop1(String stop1) {
        this.stop1 = stop1;
    }

    public String getStop2() {
        return stop2;
    }

    public void setStop2(String stop2) {
        this.stop2 = stop2;
    }

    public String getStop3() {
        return stop3;
    }

    public void setStop3(String stop3) {
        this.stop3 = stop3;
    }

    int departureTime;
    int capacity =45;
    int waitingCount = 0;
    int currentCapacity = 0;
    int departureDay;
//    Reservation reservations[];
//    Waiting waitings[];
    void Bus(){
        this.id = count;
        this.capacity = 45;
        count++;
    }

   public void increaseWaitingCount(){
        this.waitingCount++;
   }

    public int getWaitingCount() {
        return waitingCount;
    }

    void setCapacity(int capacity){
        this.capacity = capacity;
    }

    int getCapacity(){
        return capacity;
    }

    public void increaseCurrentCapacity() {
        this.currentCapacity ++;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    void setDeparture(String departure){
        this.departure = departure;
    }

    String getDeparture(){return departure;}

    void setArrival(String arrival){this.arrival = arrival;}

    String getArrival() { return arrival; }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }
}
