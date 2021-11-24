package com.example.se;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

        /**임시**/
        Bus a = new Bus();
        a.setArrival("집");
        a.setDepartureTime(8);
        Bus b = new Bus();
        b.setArrival("학교");
        b.setDepartureTime(10);
        // for(int i = 0; i<count; i++){
        arrivals.add(a.getArrival());
        // places[place_count] = a.getArrival();
        //place_count++;
        times.add(a.getDepartureTime());
        arrivals.add(b.getArrival());
        // places[place_count] = b.getArrival();
        times.add(b.getDepartureTime());
        /**임시**/
        //  }
        ArrayAdapter<String> arrivalAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                arrivals);
        arrivalSpinner.setAdapter(arrivalAdapter);

        ArrayAdapter<String> departureAdpater = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                arrivals);
        departureSpinner.setAdapter(departureAdpater);

        ArrayAdapter<Integer> timeAdapter = new ArrayAdapter<Integer>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                times);
        timeSpinner.setAdapter(timeAdapter);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time =0;
                String arrival ="";
                String departure ="";
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