package com.example.se;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

public class Home_screen  extends AppCompatActivity {
    Button informationButton, reservationButton, lineButton, noticeButton, LNFButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        informationButton = (Button) findViewById(R.id.informationButton);
        reservationButton = (Button) findViewById(R.id.reservationButton);
        lineButton = (Button) findViewById(R.id.lineButton);
        noticeButton = (Button) findViewById(R.id.noticeButton);
        LNFButton = (Button) findViewById(R.id.LNFButton);

        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Information_screen.class);
                startActivity(intent);
            }
        });
        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Reservation_screen.class);
                startActivity(intent);
            }
        });
    }
}
