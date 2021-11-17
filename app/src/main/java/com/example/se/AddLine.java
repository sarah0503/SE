package com.example.se;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddLine extends AppCompatActivity {

    ListView lineListView;
    ArrayAdapter<String> adapter;
    ArrayList<String> listItem;

    EditText lineEditText;
    Button timeAddButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_line_screen);

        lineEditText = findViewById(R.id.lineEditText);
        timeAddButton = findViewById(R.id.timeAddButton);

        //DB 사용 전
        listItem = new ArrayList<String>();
        listItem.add("출발지");
        listItem.add("경유지1");
        listItem.add("경유지2");
        listItem.add("도착지");

        timeAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItem.add(lineEditText.getText().toString());
                adapter.notifyDataSetChanged();
                lineEditText.setText("");
                //DB에도 추가??
            }
        });

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listItem);
        lineListView = findViewById(R.id.lineListView);
        lineListView.setAdapter(adapter);

        lineListView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //삭제 확인 메시지

                listItem.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
