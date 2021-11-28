package com.example.se;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Waiting_check extends AppCompatActivity{

    ArrayList<Waiting> waitingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting_check);

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
