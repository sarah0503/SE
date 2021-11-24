package com.example.se;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

public class Information_screen extends AppCompatActivity {
    Button modifyButton, withdrawButton, userinfoButton, reservationButton, waitingButton, bookmarkButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_screen);
        modifyButton = (Button) findViewById(R.id.modifyButton);
        withdrawButton = (Button) findViewById(R.id.withdrawButton);
        userinfoButton = (Button) findViewById(R.id.userinfoButton);
        reservationButton = (Button) findViewById(R.id.reservationButton);
        waitingButton = (Button) findViewById(R.id.waitingButton);
        bookmarkButton = (Button) findViewById(R.id.bookmarkButton);

        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModifyInformation.class);
                startActivity(intent);
            }
        });
        userinfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserInformation_screen.class);
                startActivity(intent);
            }
        });
    }
}