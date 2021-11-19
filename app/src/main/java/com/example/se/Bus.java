package com.example.se;

public class Bus {
    static int count = 0;
    int id;
    String departure;
    String arrival;
    String stops[];
    int dapartureTime;
    int capacity =45;
    int waitingCount = 0;
    int currentCapacity = 0;
    int departureDay;
    Reservation reservations[];
    Waiting waitings[];
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

    public void setDapartureTime(int dapartureTime) {
        this.dapartureTime = dapartureTime;
    }

    public int getDapartureTime() {
        return dapartureTime;
    }
}
