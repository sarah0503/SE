package com.example.se;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

public class Information_screen extends AppCompatActivity {
    Button modifyButton, withdrawButton, logoutButton, reservationButton, waitingButton, bookmarkButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_screen);
        modifyButton = (Button) findViewById(R.id.modifyButton);
        withdrawButton = (Button) findViewById(R.id.withdrawButton);
        logoutButton = (Button) findViewById(R.id.logoutButton);
        reservationButton = (Button) findViewById(R.id.reservationButton);
        waitingButton = (Button) findViewById(R.id.waitingButton);
        bookmarkButton = (Button) findViewById(R.id.bookmarkButton);

        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModifyInformation_check.class);
                startActivity(intent);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "로그아웃되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Reservation_check.class);
                startActivity(intent);
            }
        });
        waitingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Waiting_check.class);
                startActivity(intent);
            }
        });
        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bookmark_check.class);
                startActivity(intent);
            }
        });
    }
}