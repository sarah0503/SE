package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bookmark_check extends AppCompatActivity {

    ArrayList<Bookmark> bookmarkList;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark_check);

        btn_back = (Button) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        this.InputBookmarkData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final Bookmark_checkAdapter adapter = new Bookmark_checkAdapter(this,bookmarkList);

        listView.setAdapter(adapter);
    }
    public void InputBookmarkData()
    {
        bookmarkList = new ArrayList<Bookmark>();

        // int busId, int time, String arrival, String departure
        bookmarkList.add(new Bookmark(2345, 9, "반월당",  "영남대"));
        bookmarkList.add(new Bookmark(2678, 7, "영남대",  "대공원역"));
        bookmarkList.add(new Bookmark(2901, 15, "수성구청역",  "영남대"));
    }
}
