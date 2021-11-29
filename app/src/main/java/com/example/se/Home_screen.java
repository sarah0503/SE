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
        Intent intent = getIntent();
        final String id, pass;
        id = intent.getStringExtra("Id");
        pass = intent.getStringExtra("Pass");

        informationButton = (Button) findViewById(R.id.informationButton);
        reservationButton = (Button) findViewById(R.id.reservationButton);
        lineButton = (Button) findViewById(R.id.lineButton);
        noticeButton = (Button) findViewById(R.id.noticeButton);
        LNFButton = (Button) findViewById(R.id.LNFButton);

        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Information_screen.class);
                intent.putExtra("Id", id);
                intent.putExtra("Pass", pass);
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

        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserLineActivity.class);
                startActivity(intent);
            }
        });

        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserNoticeActivity.class);
                startActivity(intent);
            }
        });

        LNFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserLNFActivity.class);
                startActivity(intent);
            }
        });
    }
}
