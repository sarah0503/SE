package com.example.se;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Boarding_check_screen extends AppCompatActivity {

    Spinner arrivalSpinner, departureSpinner, timeSpinner;
    Button doneButton;

    String time;
    String arrival;
    String departure;

    final ArrayList<String> arrivals = new ArrayList <String> ();
    final ArrayList<String> departures = new ArrayList <String> ();
    final ArrayList<Integer> times = new ArrayList <Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boarding_check_screen);

        arrivals.add("반월당");
        arrivals.add("영남대");
        arrivals.add("달서구");
        arrivals.add("수성구");

        departures.add("반월당");
        departures.add("영남대");
        departures.add("달서구");
        departures.add("수성구");

        times.add(8);
        times.add(10);
        times.add(12);
        times.add(14);
        times.add(16);
        times.add(18);

        doneButton = (Button) findViewById(R.id.doneButton);
        departureSpinner = (Spinner) findViewById(R.id.departureSpinner);
        arrivalSpinner = (Spinner) findViewById(R.id.arrivalSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);

        ArrayAdapter<String> arrivalAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                arrivals);

        ArrayAdapter<String> departureAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                departures);

        ArrayAdapter<Integer> timeAdapter = new ArrayAdapter<Integer>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                times);

        arrivalSpinner.setAdapter(arrivalAdapter);

        departureSpinner.setAdapter(departureAdapter);

        timeSpinner.setAdapter(timeAdapter);

        arrivalAdapter.notifyDataSetInvalidated();
        departureAdapter.notifyDataSetInvalidated();
        timeAdapter.notifyDataSetInvalidated();

        arrivalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arrival = (String) arrivals.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        departureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                departure = (String) departures.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time = (String) Integer.toString(times.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time =0;
                String arrival ="";
                String departure ="";
//                arrival = arrivalSpinner.getSelectedItem().toString();
//                departure = departureSpinner.getSelectedItem().toString();
//                time = Integer.parseInt(timeSpinner.getSelectedItem().toString());

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