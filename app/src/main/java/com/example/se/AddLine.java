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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddLine extends AppCompatActivity {

    private Spinner lineAddSpinner, timeAddSpinner;
    private ArrayList<String> lineList, timeList;
    private ArrayAdapter<String> lineAdapter, timeAdapter;

    private Button cancelButton, addButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_line_screen);

        JsonParse businfo = new JsonParse();
        businfo.execute("http://yubusin.dothome.co.kr/AddLine_businfo.php");

        cancelButton = findViewById(R.id.cancelButton);
        addButton = findViewById(R.id.addButton);

        lineList = new ArrayList<>();

        lineList.add("영남대-임당역-대공원역-반월당역-경대병원역");
        lineList.add("문양역-다사역-죽전역-반고개역-영남대역");
        //addLineList(lineList);

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
                //리스트에 추가
            }
        });
    }

    void addLineList(ArrayList list){

        /****************************** DB 데이터 불러오기 ******************************/

        List<String> departureList = Arrays.asList( );

        List<String> stop1List = Arrays.asList( );

        List<String> stop2List = Arrays.asList( );

        List<String> stop3List = Arrays.asList( );

        List<String> arrivalList = Arrays.asList( );

        for(int i = 0; i < list.size(); i++) {
            /*

            list.add(departureList.get(i) + "-" + stop1List.get(i) + "-" + stop2List.get(i) + "-"
             + stop3List.get(i) + "-" + arrivalList.get(i) + "-");

            */
        }
    }

    void addTimeList(ArrayList list){

        /****************************** DB 데이터 불러오기 ******************************/

        int[] timeList = { };

        //int[] seatList = { };

        for(int i = 0; i < list.size(); i++) {
            /*

            list.add(timeList.get(i) + "시");

            */
        }
    }
}