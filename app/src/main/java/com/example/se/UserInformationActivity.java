package com.example.se;
// 완전 통과
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInformationActivity extends AppCompatActivity {
    ListView listView;
    UserInformationAdapter adapter;

    Button btn_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_activity_main);

        btn_app = (Button)findViewById(R.id.btn_app);

        btn_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Information_screen.class);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.listview);
        adapter = new UserInformationAdapter();
        /** 임시데이터 **/       // DB 에서 아이디, 이름, 이메일, 패널티 값을 가져와야함
        adapter.addItem(new UserInformation(22123456, "kim", "kim@yu.ac.kr", 1));
        adapter.addItem(new UserInformation(22123789, "Park", "Park@yu.ac.kr", 0));
        adapter.addItem(new UserInformation(22123012, "Lee", "Lee@yu.ac.kr", 2));
        listView.setAdapter(adapter);
    }
}