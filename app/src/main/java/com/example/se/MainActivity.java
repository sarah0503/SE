package com.example.se;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static Reservation reservations[] = new Reservation[100];
    public static User users[] = new User[100];
    public static Bus buses[] = new Bus[100];
//    public static Waiting waitings[] = new Waiting[100];
//    public static User currentUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}