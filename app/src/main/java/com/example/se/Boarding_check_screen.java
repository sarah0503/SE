package com.example.se;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Boarding_check_screen extends AppCompatActivity {

    Spinner arrivalSpinner, departureSpinner, timeSpinner;
    Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boarding_check_screen);

        doneButton = (Button) findViewById(R.id.doneButton);
        departureSpinner = (Spinner) findViewById(R.id.departureSpinner);
        arrivalSpinner = (Spinner) findViewById(R.id.arrivalSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);

        /***********DB**************/
        ArrayList<String> arrivals = new ArrayList <String> ();
        ArrayList<String> departures = new ArrayList <String> ();
       // int place_count = 0;
        ArrayList<Integer> times = new ArrayList <Integer>();
       // int count = Bus.count;

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time;
                String arrival;
                String departure;
                arrival = arrivalSpinner.getSelectedItem().toString();
                departure = departureSpinner.getSelectedItem().toString();
                time = Integer.parseInt(timeSpinner.getSelectedItem().toString());

                /***********DB**************/
                // time, arrival, deaparture에 맞는 버스 찾아서 버스 아이디 찾아옴
                int busId = 0;

                Intent intent = new Intent(getApplicationContext(), QRCheck.class);
                intent.putExtra("BusId", busId);
                startActivity(intent);
            }
        });

    }
}