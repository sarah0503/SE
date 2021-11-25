package com.example.se;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class UserLineActivity extends AppCompatActivity {
    private UserLineListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_line_screen);

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.userLineRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new UserLineListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {

        /******************************임의 데이터******************************/

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

        //List<String> timeList = Arrays.asList("6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19");
        int[] timeList = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        //List<String> seatList = Arrays.asList("45", "25", "22", "32", "43", "12", "16", "23", "35", "5", "11", "28", "33", "40");
        int[] seatList = {45, 25, 22, 32, 43, 12, 16, 23, 35, 5, 11, 28, 33, 40};

        /******************************임의 데이터******************************/


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