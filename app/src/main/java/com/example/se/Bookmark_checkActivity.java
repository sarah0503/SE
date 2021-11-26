package com.example.se;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Bookmark_checkActivity extends AppCompatActivity {
    //DB가 있어야 작업할 수 있는거더라....
//    DBHelper helper;
//    SQLiteDatabase db;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.bookmark_check_activity_main);
//
//        ListView listView =(ListView)findViewById(R.id.listview);
//
//        helper = new DBHelper(MainActivity.this, "newdb.db", null, 1);
//        db = helper.getWritableDatabase();
//        helper.onCreate(db);
//
//        String sql = "select * from mytable;";
//        Cursor c = db.rawQuery(sql, null);
//        String[] strs = new String[]{"txt"};
//        int[] ints = new int[] {R.id.listview_txt};
//
//        SimpleCursorAdapter adapter = null;
//        adapter = new SimpleCursorAdapter(listView.getContext(), R.layout.listview, c, strs, ints,0);
//
//        listView.setAdapter(adapter);
//
//    }
}
