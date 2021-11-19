package com.example.se;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

public class Manager_home_screen extends AppCompatActivity {
    private Button lineButton, noticeButton, LNFButton;
    private  String[] selects = {"노선 추가", "노선 변경", "노선 조회"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_home_screen);
        lineButton = (Button)findViewById(R.id.lineButton);
        noticeButton = (Button) findViewById(R.id.noticeButton);
        LNFButton = (Button) findViewById(R.id.LNFButton);

        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] selected = new int[1];
//                Intent intent = new Intent(getApplicationContext(), AddLine.class);
//                startActivity(intent);
                AlertDialog.Builder dialog = new AlertDialog.Builder(Manager_home_screen.this);
                dialog.setSingleChoiceItems(selects, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selected[0] = which;
                    }
                }).setNeutralButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(selected[0] == 0){
                            Intent intent = new Intent(getApplicationContext(), AddLine.class);
                            startActivity(intent);
                        }
                        else if(selected[0] ==1){

                        }
                        else if(selected[0] ==2){

                        }
                    }
                }).show();
            }
        });
    }
}
