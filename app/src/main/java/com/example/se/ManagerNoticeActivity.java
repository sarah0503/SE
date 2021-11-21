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

public class ManagerNoticeActivity extends AppCompatActivity {

    private ManagerNoticeListAdapter adapter;
    private Button noticeAddButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_screen);
        noticeAddButton = findViewById(R.id.noticeAddButton);

        noticeAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddNotice.class);
                startActivity(intent);
            }
        });

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.noticeRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ManagerNoticeListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() { //임의 데이터
        List<String> titleList = Arrays.asList("제목1", "제목2", "제목3", "제목4", "제목5", "제목6", "제목7",
                "제목8", "제목9", "제목10", "제목11", "제목12");

        List<String> dateList = Arrays.asList("날짜1", "날짜2", "날짜3", "날짜4", "날짜5", "날짜6", "날짜7",
                "날짜8", "날짜9", "날짜10", "날짜11", "날짜12");

        for(int i = 0; i < titleList.size(); i++) {
            Notice notice = new Notice();
            notice.setTitle(titleList.get(i));
            notice.setDate(dateList.get(i));

            adapter.addItem(notice);
        }

        adapter.notifyDataSetChanged();
    }
}
