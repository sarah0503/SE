package com.example.se;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddLine extends AppCompatActivity {

    private Spinner departureAddSpinner, arrivalAddSpinner, timeAddSpinner;
    private ArrayList<String> departureList, arrivalList, timeList;
    private ArrayAdapter<String> departureAdapter, arrivalAdapter, timeAdapter;

    private Button cancelButton, addButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_line_screen);

        cancelButton = findViewById(R.id.cancelButton);
        addButton = findViewById(R.id.addButton);

        departureList = new ArrayList<>();
        //lineList = addLIneList( DB로 받아온 ArrayLIst<Bus> , departureList )
        departureList.add("출발지1");
        departureList.add("출발지2");
        departureList.add("출발지3");

        departureAddSpinner = (Spinner) findViewById(R.id.departureAddSpinner);
        departureAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,departureList);
        departureAddSpinner.setAdapter(departureAdapter);
        departureAddSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //출발지 선택했을 때: DB에 조회할 수 있는 노선으로 추가
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

        arrivalList = new ArrayList<>();
        //lineList = addLIneList( DB로 받아온 ArrayLIst<Bus> , arrivalList )
        arrivalList.add("출발지1");
        arrivalList.add("출발지2");
        arrivalList.add("출발지3");

        arrivalAddSpinner = (Spinner) findViewById(R.id.arrivalAddSpinner);
        arrivalAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrivalList);
        arrivalAddSpinner.setAdapter(arrivalAdapter);
        arrivalAddSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //도착지 선택했을 때: DB에 조회할 수 있는 노선으로 추가
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

        timeList = new ArrayList<>();

        timeList.add("8");
        timeList.add("10");
        //addTimeList(timeList);

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
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //리스트에 추가 후 종료

                finish();
            }
        });
    }

    void addLineList(ArrayList<Bus> busList, ArrayList<String> lineList){ /** DB 데이터 불러오면 스피너에 추가하는 메소드 **/
        for(int i = 0; i < busList.size(); i++) {
            lineList.add(busList.get(i).getDeparture());
        }
    }

    void addTimeList(ArrayList<Bus> busList, ArrayList<String> timeList){
        for(int i = 0; i < busList.size(); i++) {
            timeList.add(busList.get(i).getDepartureTime() + "");
        }
    }
}