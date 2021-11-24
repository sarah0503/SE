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

public class ManagerLNFActivity extends AppCompatActivity {

    private ManagerLNFListAdapter adapter;
    private Button lnfAddButton;
    private Button lnfDeleteButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lnf_screen);
        lnfAddButton = findViewById(R.id.lnfAddButton);
        lnfDeleteButton = findViewById(R.id.lnfDeleteButton);

        lnfAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddLNF.class);
                startActivity(intent);
            }
        });

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.lnfRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ManagerLNFListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        List<String> titleList = Arrays.asList("제목1", "제목2", "제목3", "제목4", "제목5", "제목6", "제목7",
                "제목8", "제목9", "제목10", "제목11", "제목12");

        //image

        List<String> explainList = Arrays.asList("날짜1", "날짜2", "날짜3", "날짜4", "날짜5", "날짜6", "날짜7",
                "날짜8", "날짜9", "날짜10", "날짜11", "날짜12");

        for(int i = 0; i < titleList.size(); i++) {
            LNF lnf = new LNF();
            lnf.setTitle(titleList.get(i));
            lnf.setExplain(explainList.get(i));

            adapter.addItem(lnf);
        }

        adapter.notifyDataSetChanged();
    }
}
