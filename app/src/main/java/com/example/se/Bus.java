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
    Wating watings[];
    void Bus(int id){
        this.id = id;
        count++;
    }
    void setCapacity(int capacity){
        this.capacity = capacity;
    }
    int getCapacity(){
        return capacity;
    }
    void setDeparture(String departure){
        this.departure = departure;
    }
}
