package com.example.se;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Reservation_screen extends AppCompatActivity {
    Spinner placeSpinner, timeSpinner;
    Button doneButton;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resevation_screen);

        doneButton = (Button) findViewById(R.id.doneButton);
        placeSpinner = (Spinner) findViewById(R.id.placeSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);
        ArrayList<String> places = new ArrayList <String> ();
        //String places[] = new String[100];
        int place_count = 0;
        ArrayList<Integer> times = new ArrayList <Integer>();
        int count = Bus.count;
        /****/
        Bus a = new Bus();
        a.setArrival("집");
        a.setDapartureTime(8);
        Bus b = new Bus();
        b.setArrival("학교");
        b.setDapartureTime(10);
       // for(int i = 0; i<count; i++){
            places.add(a.getArrival());
           // places[place_count] = a.getArrival();
            //place_count++;
            times.add(a.getDapartureTime());
            places.add(b.getArrival());
           // places[place_count] = b.getArrival();
            times.add(b.getDapartureTime());

      //  }
        ArrayAdapter<String> placeAdpater = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                places);
        placeSpinner.setAdapter(placeAdpater);

        ArrayAdapter<Integer> timeAdapter = new ArrayAdapter<Integer>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                times);
        timeSpinner.setAdapter(timeAdapter);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time;
                String place;
                place = placeSpinner.getSelectedItem().toString();
                time = Integer.parseInt(timeSpinner.getSelectedItem().toString());
                MainActivity.reservations[Reservation.count] = new Reservation();
                MainActivity.reservations[Reservation.count].setPlace(place);
                MainActivity.reservations[Reservation.count].setTime(time);
                Reservation.count++;
                //currentUser.addReservation(temp);
            }
        });


    }
}
