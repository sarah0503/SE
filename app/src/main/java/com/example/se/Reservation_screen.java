package com.example.se;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Reservation_screen extends AppCompatActivity {
    Spinner placeSpinner, timeSpinner;
    Button doneButton;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resevation_screen);

        placeSpinner = (Spinner) findViewById(R.id.placeSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);
        doneButton = (Button) findViewById(R.id.doneButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time;
                String place;
                place = placeSpinner.getSelectedItem().toString();
                time = Integer.parseInt(timeSpinner.getSelectedItem().toString());
                Reservation temp = new Reservation();
                temp.setPlace(place);
                temp.setTime(time);
                
            }
        });


    }
}
