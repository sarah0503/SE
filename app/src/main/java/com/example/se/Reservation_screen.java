package com.example.se;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.*;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Reservation_screen extends AppCompatActivity {
    Spinner arrivalSpinner, departureSpinner, timeSpinner;
    Button doneButton;
//    ArrayList<ClipData.Item> items= new ArrayList<>();
//    ItemAdapter adapter;
    private static final String TAG_RESULT = "result";
    private static final String TAG_ARRIVAL = "startpnt";
    private static final String TAG_DEPARTURE = "destpnt";
    private static final String TAG_TIME = "starttime";
    private  static final String TAG = "RESULT";

    String time;
    String arrival;
    String departure;


     static RequestQueue queue;
    private Map<String, String> parameters;

     final ArrayList<String> arrivals = new ArrayList <String> ();
    final ArrayList<String> departures = new ArrayList <String> ();
    int place_count = 0;
    final ArrayList<Integer> times = new ArrayList <Integer>();


//    public class request extends StringRequest{
//        final  static private String URL = "http://yubusin.dothome.co.kr/reservation_screen_businfo.php";
//
//        public request(String startpnt, String destpnt, int starttime, Response.Listener<String> listener){
//            super(Method.POST, URL, listener, null);
//            parameters = new HashMap<>();
//            parameters.put("arrivlas", startpnt);
//            parameters.put("departures", destpnt);
//            parameters.put("times", Integer.toString(starttime));
//        }
//
//        public Map<String , String> getParams(){
//            return parameters;
//        }
//    }


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_screen);
        JSONArray buses = null;

      String URL1 = "http://yubusin.dothome.co.kr/reservation_screen_businfo.php";
      String URL2 = "http://yubusin.dothome.co.kr/reservation_screen_allbusinfo.php";
        if (queue != null) {
            queue.cancelAll(TAG);
        }
        if(queue == null) {
            try {
                queue = Volley.newRequestQueue(Reservation_screen.this);
            }catch (Exception e){ e.printStackTrace();}
        }

        StringRequest request = new StringRequest(Request.Method.GET, URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonObject = new JSONArray(response);

                    for (int i = 0; i < jsonObject.length(); i++) {
                        JSONObject obj = jsonObject.getJSONObject(i);
                        String startpnt = obj.getString("startpnt");
                        String destpnt =obj.getString("destpnt");
                        Integer starttime = obj.getInt("starttime");
                        arrivals.add(startpnt);
                        departures.add(destpnt);
                        times.add((starttime));
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

        doneButton = (Button) findViewById(R.id.doneButton);
        departureSpinner = (Spinner) findViewById(R.id.departureSpinner);
        arrivalSpinner = (Spinner) findViewById(R.id.arrivalSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);
        /***********DB**************/
       // int count = Bus.count;

        ArrayAdapter<String> arrivalAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                arrivals);

        ArrayAdapter<String> departureAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                departures);

        ArrayAdapter<Integer> timeAdapter = new ArrayAdapter<Integer>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                times);

//        arrivalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        departureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        arrivalSpinner.setAdapter(arrivalAdapter);

        departureSpinner.setAdapter(departureAdapter);

        timeSpinner.setAdapter(timeAdapter);

        arrivalAdapter.notifyDataSetInvalidated();
        departureAdapter.notifyDataSetInvalidated();
        timeAdapter.notifyDataSetInvalidated();

        arrivalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arrival = (String) arrivals.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        departureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                departure = (String) departures.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time = (String) Integer.toString(times.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                arrival = arrivalSpinner.getSelectedItem().toString();
                departure = departureSpinner.getSelectedItem().toString();
                time = (timeSpinner.getSelectedItem().toString());

                /***********DB**************/
                //버스아이디 찾아서 버스 객체 찾기
                Bus currentBus = new Bus();
                StringRequest request1 = new StringRequest(Request.Method.GET, URL2, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("arrival", arrival);
                        params.put("departure", departure);
                        params.put("time", time);
                        return params;

                    }
                };
                request1.setTag(TAG);
                queue.add(request1);

                if(currentBus.getCurrentCapacity() >= currentBus.getCapacity()){


                    AlertDialog.Builder failureDialog = new AlertDialog.Builder(Reservation_screen.this);
                    failureDialog.setMessage("예약을 실패하였습니다. .");
                    failureDialog.setPositiveButton("대기 ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.waitings[Waiting.count] = (Waiting) new Waiting();
                            /**얘네 다 필요 없을 듯
                            MainActivity.waitings[Waiting.count-1].setTime(time);
                            MainActivity.waitings[Waiting.count-1].setArrival(arrival);
                            MainActivity.waitings[Waiting.count-1].setDeparture(departure); **/

                            String waitingCount = Integer.toString(currentBus.getWaitingCount());
                            MainActivity.waitings[Waiting.count-1].setWaitingCount(Integer.parseInt(waitingCount));

                            /***********DB**************/
                            //디비에 대기 정보 저장

                            /**디비쓰면 얘네 필요 없을수도,,**/
                            MainActivity.waitings[Waiting.count-1].setBusId(currentBus.id);
                            currentBus.increaseWaitingCount();
                            MainActivity.waitings[Waiting.count-1].setUserId(MainActivity.currentUser.getUserID());



                            Toast.makeText(getApplicationContext(), "대기번호 :  " + waitingCount,Toast.LENGTH_LONG).show();
                        }
                    });
                    failureDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = failureDialog.create();
                    alertDialog.show();

                }//예약 실패 ==> 대기
                else{

                    MainActivity.reservations[Reservation.count] = new Reservation();
                    /**얘네 다 필요 없을 듯
                    MainActivity.reservations[Reservation.count-1].setArrival(arrival);
                    MainActivity.reservations[Reservation.count-1].setDeparture(departure);
                    MainActivity.reservations[Reservation.count-1].setTime(time);        **/

                    /***********DB**************/
                    //디비에 예매 정보 저장

                    /**디비쓰면 얘네 필요 없을수도,,**/
                    MainActivity.reservations[Reservation.count-1].setBusId(currentBus.id);
                    MainActivity.reservations[Reservation.count-1].setUserId(MainActivity.currentUser.getUserID());
                    currentBus.increaseCurrentCapacity();

                    AlertDialog.Builder reservationDialog = new AlertDialog.Builder(Reservation_screen.this);
                    reservationDialog.setMessage("예약이 완료되었습니다. ");
                    reservationDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });


                    AlertDialog alertDialog = reservationDialog.create();
                    alertDialog.show();
                }//예약 성공
            }
        });


    }
}
