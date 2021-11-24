package com.example.se;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class UserLNFActivity extends AppCompatActivity {

    private UserLNFListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_lnf_screen);

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.userLnfRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new UserLNFListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        List<String> titleList = Arrays.asList("제목1", "제목2", "제목3", "제목4", "제목5", "제목6", "제목7",
                "제목8", "제목9", "제목10", "제목11", "제목12");

        for(int i = 0; i < titleList.size(); i++) {
            LNF lnf = new LNF();
            lnf.setTitle(titleList.get(i));

            adapter.addItem(lnf);
        }

        adapter.notifyDataSetChanged();
    }
}
