package com.example.se;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagerLineActivity extends AppCompatActivity {

    private ManagerLineListAdapter adapter;
    private Button addButton;

    private Dialog addDialog;
    private Spinner lineAddSpinner, timeAddSpinner;
    private ArrayList<String> lineList, timeList;
    private ArrayAdapter<String> lineAdapter, timeAdapter;
    private Button cancelButton, addLineButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_screen);
        addButton = findViewById(R.id.lineAddButton);

        init();

        getData();

        addButton.setOnClickListener(new View.OnClickListener() { //노선 추가 버튼을 눌렀을 때
            @Override
            public void onClick(View v) {
                addDialog = new Dialog(v.getContext());
                addDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                addDialog.setContentView(R.layout.add_line_screen);
                WindowManager.LayoutParams params = addDialog.getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                addDialog.getWindow().setAttributes((WindowManager.LayoutParams) params);

                addDialog.show();

                cancelButton = addDialog.findViewById(R.id.cancelButton);
                addLineButton = addDialog.findViewById(R.id.addButton);

                /*lineList = new ArrayList<>();

                lineList.add("영남대-임당역-대공원역-반월당역-경대병원역");
                lineList.add("문양역-다사역-죽전역-반고개역-영남대역");*/
                addLineList(adapter.busArrayList);

                lineAddSpinner = (Spinner) findViewById(R.id.lineAddSpinner);
                lineAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,lineList);
                lineAddSpinner.setAdapter(lineAdapter);
                lineAddSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        //노선 선택했을 때
                        //Toast.makeText(getApplicationContext(),lineList.get(i)+" 선택", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(adapterView.getContext());
                        builder.setTitle("Confirm");
                        builder.setMessage("노선이 선택되지 않았습니다.");
                        builder.setPositiveButton("닫기", null);
                        builder.create().show();
                    }
                });

                /*timeList = new ArrayList<>();

                timeList.add("8");
                timeList.add("10");*/
                addTimeList(adapter.busArrayList);

                timeAddSpinner = (Spinner) findViewById(R.id.timeAddSpinner);
                timeAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, timeList);
                timeAddSpinner.setAdapter(timeAdapter);
                timeAddSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        //시간 선택했을 때
                        //Toast.makeText(getApplicationContext(),timeList.get(i)+" 선택", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(adapterView.getContext());
                        builder.setTitle("Confirm");
                        builder.setMessage("시간이 선택되지 않았습니다.");
                        builder.setPositiveButton("닫기", null);
                        builder.create().show();
                    }
                });

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addDialog.dismiss();
                    }
                });

                addLineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //리스트에 추가

                        addDialog.dismiss();
                    }
                });
            }
        });
    }

    void addLineList(ArrayList<Bus> bus){

        /****************************** DB 데이터 불러오기 ******************************

        List<String> departureList = Arrays.asList( );

        List<String> stop1List = Arrays.asList( );

        List<String> stop2List = Arrays.asList( );

        List<String> stop3List = Arrays.asList( );

        List<String> arrivalList = Arrays.asList( );    */

        ArrayList<String> lineList = new ArrayList<>();

        for(int i = 0; i < bus.size(); i++) {
            lineList.add(bus.get(i).getDeparture() + "-" + bus.get(i).getStop1() + "-" + bus.get(i).getStop2() + "-"
                    + bus.get(i).getStop3() + "-" + bus.get(i).getArrival());
        }
    }

    void addTimeList(ArrayList<Bus> bus){

        /****************************** DB 데이터 불러오기 ******************************/

        //int[] timeList = { };

        //int[] seatList = { };

        ArrayList<String> timeList = new ArrayList<>();

        for(int i = 0; i < bus.size(); i++) {
            timeList.add(bus.get(i).getDepartureTime() + "시");
        }
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.manageRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ManagerLineListAdapter();
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

        int[] timeList = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        int[] seatList = {45, 25, 22, 32, 43, 12, 16, 23, 35, 5, 11, 28, 33, 40};

        /**********************************************************************/

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
