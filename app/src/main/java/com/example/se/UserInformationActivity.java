package com.example.se;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserInformationActivity extends AppCompatActivity {
    ListView listView;
    UserInformAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_activity_main);

        listView = findViewById(R.id.listview);
        adapter = new UserInformAdapter();
        /** 임시데이터 **/       // DB 에서 아이디, 이름, 이메일, 패널티 값을 가져와야함
        adapter.addItem(new UserInformation(22123456, "kim", "kim@yu.ac.kr", 1));
        listView.setAdapter(adapter);
    }
}