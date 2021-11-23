package com.example.se;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.InsetDialogOnTouchListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddLine extends AppCompatActivity { //extends Dialog
    private Context context;

    private Spinner lineAddSpinner, timeAddSpinner;
    private ArrayList<String> lineList, timeList;
    private ArrayAdapter<String> lineAdapter, timeAdapter;

    private InsetDialogOnTouchListener listener;
    private TextView addTitleTextView;
    private Button cancelButton, addButton;

    //public AddLine(@NonNull Context context) {
    //    super(context);
    //    this.context = context;
    //}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_line_screen);

        addTitleTextView = findViewById(R.id.addTitleTextView);
        cancelButton = findViewById(R.id.cancelButton);
        addButton = findViewById(R.id.addButton);

        lineList = new ArrayList<>();
        //임의 데이터
        lineList.add("영남대-임당역-대공원역-반월당역-경대병원역");
        lineList.add("문양역-다사역-죽전역-반고개역-영남대역");
        //
        lineAddSpinner = (Spinner) findViewById(R.id.lineAddSpinner);
        lineAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,lineList);
        lineAddSpinner.setAdapter(lineAdapter);
        lineAddSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //노선 선택했을 때
                Toast.makeText(getApplicationContext(),lineList.get(i)+" 선택", Toast.LENGTH_SHORT).show();
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
        //임의 데이터
        timeList.add("8");
        timeList.add("10");
        //
        timeAddSpinner = (Spinner) findViewById(R.id.timeAddSpinner);
        timeAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, timeList);
        timeAddSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //시간 선택했을 때
                Toast.makeText(getApplicationContext(),timeList.get(i)+" 선택", Toast.LENGTH_SHORT).show();
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
    }
}