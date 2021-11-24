package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagerLineActivity extends AppCompatActivity {

    private ManagerLineListAdapter adapter;
    private Button addButton;
    private Button editButton;
    private Button deleteButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_screen);
        addButton = findViewById(R.id.lineAddButton);
        editButton = findViewById(R.id.lineEditButton);
        deleteButton = findViewById(R.id.lineDeleteButton);

        addButton.setOnClickListener(new View.OnClickListener() { //노선 추가 버튼을 눌렀을 때
            @Override
            public void onClick(View v) {
                //spinner
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() { //노선 변경 버튼을 눌렀을 때
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditLine.class);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() { //노선 삭제 버튼을 눌렀을 때
            @Override
            public void onClick(View view) {
                //노선 선택 삭제
            }
        });

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.manageRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ManagerLineListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() { //임의 데이터
        List<String> departureList = Arrays.asList("영남대역", "출발지2", "출발지3", "출발지4", "출발지5", "출발지6", "출발지7",
                "출발지8", "출발지9", "출발지10", "출발지11", "출발지12", "출발지13", "출발지14");

        List<String> stop1List = Arrays.asList("대공원역", "경유지2", "경유지3", "경유지4", "경유지5", "경유지6", "경유지7",
                "경유지8", "경유지9", "경유지10", "경유지11", "경유지12", "경유지13", "경유지14");

        List<String> stop2List = Arrays.asList("대구은행", "경유지2", "경유지3", "경유지4", "경유지5", "경유지6", "경유지7",
                "경유지8", "경유지9", "경유지10", "경유지11", "경유지12", "경유지13", "경유지14");

        List<String> stop3List = Arrays.asList("반월당", "경유지2", "경유지3", "경유지4", "경유지5", "경유지6", "경유지7",
                "경유지8", "경유지9", "경유지10", "경유지11", "경유지12", "경유지13", "경유지14");

        List<String> arrivalList = Arrays.asList("반고개", "도착지2", "도착지3", "도착지4", "도착지5", "도착지6", "도착지7",
                "도착지8", "도착지9", "도착지10", "도착지11", "도착지12", "도착지13", "도착지14");

        int[] timeList = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        int[] seatList = {45, 25, 22, 32, 43, 12, 16, 23, 35, 5, 11, 28, 33, 40};

        for(int i = 0; i < departureList.size(); i++) {
            Bus bus = new Bus();
            bus.setDeparture(departureList.get(i));
            bus.setStop1(stop1List.get(i));
            bus.setStop2(stop2List.get(i));
            bus.setStop3(stop3List.get(i));
            bus.setArrival(arrivalList.get(i));
            bus.setDepartureTime(timeList[i]);
            bus.setCapacity(seatList[i]);

            adapter.addItem(bus);
        }

        adapter.notifyDataSetChanged();
    }
}
