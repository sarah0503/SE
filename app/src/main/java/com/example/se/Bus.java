package com.example.se;

public class Bus {
    static int count = 0;
    int id;
    String departure;
    String arrival;
    String stops[];
    int dapartureTime;
    int capacity;
    int departureDay;
    Reservation reservations[];
    Waiting waitings[];
    void Bus(int id){
        this.id = id;
        count++;
    }
    void setCapacity(int capacity){this.capacity = capacity;}
    int getCapacity(){ return capacity; }
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
