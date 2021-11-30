package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Waiting_check extends AppCompatActivity{

    ArrayList<Waiting> waitingList;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting_check);

        btn_back = (Button) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        this.InputWaitingData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final Waiting_checkAdapter adapter = new Waiting_checkAdapter(this,waitingList);

        listView.setAdapter(adapter);
    }
    public void InputWaitingData()
    {
        waitingList = new ArrayList<Waiting>();

        // int busId, int time, int waitingCount, String arrival, String departure
        waitingList.add(new Waiting(2345, 9, 23, "반월당", "영남대"));
        waitingList.add(new Waiting(2678, 7, 5, "영남대", "대공원역"));
        waitingList.add(new Waiting(2901, 15, 19, "수성구청역", "영남대"));
    }
}
