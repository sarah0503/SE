package com.example.se;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

public class Manager_home_screen extends AppCompatActivity {
    Button lineButton, noticeButton, LNFButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_home_screen);
        lineButton = (Button)findViewById(R.id.lineButton);
        noticeButton = (Button) findViewById(R.id.noticeButton);
        LNFButton = (Button) findViewById(R.id.LNFButton);

        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddLine.class);
                startActivity(intent);
            }
        });
    }
}
