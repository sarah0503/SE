package com.example.se;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserLineActivity extends AppCompatActivity {
    private UserLineListAdapter adapter;


    static RequestQueue queue;
    private  static final String TAG = "RESULT";


    final    ArrayList<String> departureList = new ArrayList<String>();// = Arrays.asList("영남대역", "출발지2", "출발지3", "출발지4", "출발지5", "출발지6", "출발지7",
    //  "출발지8", "출발지9", "출발지10", "출발지11", "출발지12", "출발지13", "출발지14");

    final   ArrayList<String> stop1List =new ArrayList <String> ();// = Arrays.asList("대공원역", "경유지2", "경유지3", "경유지4", "경유지5", "경유지6", "경유지7",
    // "경유지8", "경유지9", "경유지10", "경유지11", "경유지12", "경유지13", "경유지14");

    final   ArrayList<String> stop2List= new ArrayList <String> ();// = Arrays.asList("대구은행", "경유지2", "경유지3", "경유지4", "경유지5", "경유지6", "경유지7",
    //  "경유지8", "경유지9", "경유지10", "경유지11", "경유지12", "경유지13", "경유지14");

    final ArrayList<String> stop3List= new ArrayList <String> ();// = Arrays.asList("반월당", "경유지2", "경유지3", "경유지4", "경유지5", "경유지6", "경유지7",
    // "경유지8", "경유지9", "경유지10", "경유지11", "경유지12", "경유지13", "경유지14");

    final ArrayList<String> arrivalList= new ArrayList <String> ();// = Arrays.asList("반고개", "도착지2", "도착지3", "도착지4", "도착지5", "도착지6", "도착지7",
    // "도착지8", "도착지9", "도착지10", "도착지11", "도착지12", "도착지13", "도착지14");

       final ArrayList<Integer> timeList= new ArrayList <Integer> ();// = Arrays.asList("6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19");
    //int[] timeList = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        ArrayList<Integer> seatList = new ArrayList <Integer> ();;//= Arrays.asList("45", "2

    String URL1 = "http://yubusin.dothome.co.kr/managerlineactivity_businfo.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_line_screen);


        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.userLineRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new UserLineListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {

        if(queue == null) {
            try {
                queue = Volley.newRequestQueue(UserLineActivity.this);
            }catch (Exception e){ e.printStackTrace();}
        }
        /******************************임의 데이터******************************/
//5", "22", "32", "43", "12", "16", "23", "35", "5", "11", "28", "33", "40");
        //int[] seatList = {45, 25, 22, 32, 43, 12, 16, 23, 35, 5, 11, 28, 33, 40};

        StringRequest request = new StringRequest(Request.Method.GET, URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonObject = new JSONArray(response);

                    for (int i = 0; i < jsonObject.length(); i++) {
                        JSONObject obj = jsonObject.getJSONObject(i);
                        departureList.add(obj.getString("destpnt"));
                        stop1List.add(obj.getString("waypnt1"));
                        stop2List.add(obj.getString("waypnt2"));
                        stop3List.add(obj.getString("waypnt3"));
                        arrivalList.add(obj.getString("startpnt"));
                        timeList.add(Integer.parseInt(obj.getString("starttime")));
                        seatList.add(Integer.parseInt(obj.getString("reservseat")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        request.setTag(TAG);
        queue.add(request);

        /******************************임의 데이터******************************/


        for(int i = 0; i < departureList.size(); i++) {
            Bus bus = new Bus();
            bus.setDeparture(departureList.get(i));
            bus.setStop1(stop1List.get(i));
            bus.setStop2(stop2List.get(i));
            bus.setStop3(stop3List.get(i));
            bus.setArrival(arrivalList.get(i));
            bus.setDepartureTime(timeList.get(i));
            bus.setCapacity(seatList.get(i));

            adapter.addItem(bus);
        }

        adapter.notifyDataSetChanged();
    }
}