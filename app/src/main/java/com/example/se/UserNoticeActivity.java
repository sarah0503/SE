package com.example.se;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class UserNoticeActivity extends AppCompatActivity {

    UserNoticeListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_notice_screen);

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.userNoticeRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new UserNoticeListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        // 임의 데이터
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
                "내용6",
                "내용7",
                "내용8",
                "내용9",
                "내용10",
                "내용11",
                "내용12");

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
