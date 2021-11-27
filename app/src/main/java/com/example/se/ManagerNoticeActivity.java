package com.example.se;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ManagerNoticeActivity extends AppCompatActivity {

    private ManagerNoticeListAdapter adapter;
    private Button noticeAddButton;
    private Dialog addDialog;
    private Button noticeInputButton;
    private EditText inputTitleEditText, inputContentEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_screen);
        noticeAddButton = findViewById(R.id.noticeAddButton);

        init();

        getData();

        noticeAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDialog = new Dialog(view.getContext());
                addDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                addDialog.setContentView(R.layout.add_notice_screen);
                WindowManager.LayoutParams params = addDialog.getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.MATCH_PARENT;
                addDialog.getWindow().setAttributes((WindowManager.LayoutParams) params);

                addDialog.show();

                noticeInputButton = addDialog.findViewById(R.id.noticeInputButton);
                inputTitleEditText = addDialog.findViewById(R.id.inputTitleEditText);
                inputContentEditText = addDialog.findViewById(R.id.inputContentEditText);

                noticeInputButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Notice notice = new Notice();
                        notice.setTitle(inputTitleEditText.getText().toString());
                        notice.setContent(inputContentEditText.getText().toString());
                        notice.setDate("0000.00.00");

                        adapter.addItem(notice);
                        adapter.notifyDataSetChanged();


                        addDialog.dismiss();
                    }
                });
            }
        });
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.noticeRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ManagerNoticeListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {

        /******************************임의 데이터******************************/

        List<String> titleList = Arrays.asList("오늘의 공지사항", "제목2", "제목3", "제목4", "제목5", "제목6", "제목7",
                "제목8", "제목9", "제목10", "제목11", "제목12");

        List<String> dateList = Arrays.asList("2021.08.26", "날짜2", "날짜3", "날짜4", "날짜5", "날짜6", "날짜7",
                "날짜8", "날짜9", "날짜10", "날짜11", "날짜12");


        List<String> contentList = Arrays.asList(
                "버스 노선이 변경되었습니다.",
                "버스 노선이 삭제되었습니다.",
                "버스 출발 시간이 변경되었습니다.",
                "오늘 하루 버스 운행을 중단합니다.",
                "업데이트 알림",
                "내용666666666666666666666666666666666666666666666666666666666666666",
                "내용777777777777777777777777777777777777777777777777777777777777777",
                "내용888888888888888888888888888888888888888888888888888888888888888",
                "내용9-----------------999999--------------99999--------------------",
                "내용10++-+--+-+-+110101011010+-+-+-+-+-+--+-+6554464548561351846651",
                "내용11내용내용내용내용내용내용낸용내용내용내용ㅇㅇㅇㅇㅇㅇㅇㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ",
                "내용12~~~~~~~~12~~~~~~~~~~`%~~~~~~``^~~~~~`#$%##%^#$%@#$!@#~!@#!@#$");

        /************************************************************************/


        for(int i = 0; i < titleList.size(); i++) {
            Notice notice = new Notice();
            notice.setTitle(titleList.get(i));
            notice.setDate(dateList.get(i));
            notice.setContent(contentList.get(i));

            adapter.addItem(notice);
        }

        adapter.notifyDataSetChanged();
    }
}