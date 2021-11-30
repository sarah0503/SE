package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Reservation_check extends AppCompatActivity {

    ArrayList<Reservation> reservationList;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_check);

        btn_back = (Button) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        this.InputReservationData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final Reservtion_checkAdapter adapter = new Reservtion_checkAdapter(this,reservationList);

        listView.setAdapter(adapter);

    }

    public void InputReservationData()
    {
        reservationList = new ArrayList<Reservation>();

        // int busId, String arrival, String departure, int time
        reservationList.add(new Reservation(1234, "영남대", "반월당", 9));
        reservationList.add(new Reservation(1567, "대공원역", "영남대", 14));
        reservationList.add(new Reservation(1890, "영남대", "수성구청역", 18));
    }
}