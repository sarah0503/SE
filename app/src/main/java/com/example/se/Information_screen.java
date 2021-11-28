package com.example.se;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.WindowManager;
import android.widget.*;

public class Information_screen extends AppCompatActivity {
    Button modifyButton, withdrawButton, reservationButton, waitingButton, bookmarkButton;
    EditText nameEditText, iDEditText, pwEditText;
    String name, id, pw;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_screen);
        modifyButton = (Button) findViewById(R.id.modifyButton);
        withdrawButton = (Button) findViewById(R.id.withdrawButton);
        reservationButton = (Button) findViewById(R.id.reservationButton);
        waitingButton = (Button) findViewById(R.id.waitingButton);
        bookmarkButton = (Button) findViewById(R.id.bookmarkButton);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        iDEditText = (EditText) findViewById(R.id.iDEditText);
        pwEditText = (EditText) findViewById(R.id.pwEditText);

        name = nameEditText.getText().toString();
        id = iDEditText.getText().toString();
        pw = pwEditText.getText().toString();


        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Reservation_check.class);
//                intent.putExtra("Id" ,id);
//                startActivity(intent);
            }
        });
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModifyInformation_check.class);
                intent.putExtra("Id" ,id);
                startActivity(intent);

            }
        });
        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //디비에서 데이터 삭제
            }
        });
        waitingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Waiting_check.class);
                intent.putExtra("Id" ,id);
                startActivity(intent);
            }
        });
        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //북마크 버튼
            }
        });
    }
}