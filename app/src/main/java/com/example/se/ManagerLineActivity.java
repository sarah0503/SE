package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ManagerLineActivity extends AppCompatActivity {

    private ManagerLineListAdapter adapter;
    private Button addButton;
    private Button editButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inquiry_route_screen);
        addButton = findViewById(R.id.addButton);
        editButton = findViewById(R.id.editButton);

        addButton.setOnClickListener(new View.OnClickListener() { //노선 추가 버튼을 눌렀을 때
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddLine.class);
                startActivity(intent);
            }
        });

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.inquiryRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ManagerLineListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() { //임의 데이터
        List<String> departureList = Arrays.asList("출발지1", "출발지2", "출발지3", "출발지4", "출발지5", "출발지6", "출발지7",
                "출발지8", "출발지9", "출발지10", "출발지11", "출발지12");

        List<String> arrivalList = Arrays.asList("도착지1", "도착지2", "도착지3", "도착지4", "도착지5", "도착지6", "도착지7",
                "도착지8", "도착지9", "도착지10", "도착지11", "도착지12");

        for(int i = 0; i < departureList.size(); i++) {
            Bus bus = new Bus();
            bus.setDeparture(departureList.get(i));
            bus.setArrival(arrivalList.get(i));

            adapter.addItem(bus);
        }

        adapter.notifyDataSetChanged();
    }
}