//package com.example.se;
//
//import android.app.Activity;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.app.Activity;
//import android.os.AsyncTask;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import org.json.JSONArray;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
//public class Reservation_check extends AppCompatActivity {
//
//    ListView listView;
//    ArrayList<String> adapter;
//    DBHelper helper;
//    SQLiteDatabase db;
//
//    private static final String TAR_ARRIVAL = "출발지";
//    private static final String TAR_DEPARTURE = "도착지";
//    private static final String TAR_TIME = "시간";
//
//    static String query;
//    /******DB******/
//
//    JSONArray reservations = null;
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.reservation_check);
//
//        listView = (findViewById(R.id.listView));
//
//        helper = new DBHelper(Reservation_check.this, "newdb.db", null, 1);
//
//        db = helper.getWritebaleDatabase();
//        helper.onCreate;
//
//
//    }
//
//
//}
//
//
//
//}
