package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserInformation_screen extends AppCompatActivity {

    TextView textViewID;
    TextView textViewEmail;
    TextView textViewPenalty;
    TextView textViewQR;
    Button btn_back;

    User user = new User();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_screen);

        textViewID = (TextView)findViewById(R.id.textViewID);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);
        textViewPenalty = (TextView)findViewById(R.id.textViewPenalty);
        textViewQR = (TextView)findViewById(R.id.textViewQR);
        btn_back = (Button)findViewById(R.id.btn_back);

        //DB 에서 사용자 정보를 읽어와서 ID, Email, Penalty, QR을 표시

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Information_screen.class);
                startActivity(intent);
            }
        });
    }
}