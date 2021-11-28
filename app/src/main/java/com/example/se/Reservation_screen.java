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

    String time;
    String arrival;
    String departure;

    final ArrayList<String> arrivals = new ArrayList <String> ();
    final ArrayList<String> departures = new ArrayList <String> ();
    final ArrayList<Integer> times = new ArrayList <Integer>();


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_screen);

        arrivals.add("반월당");
        arrivals.add("영남대");
        arrivals.add("달서구");
        arrivals.add("수성구");

        departures.add("반월당");
        departures.add("영남대");
        departures.add("달서구");
        departures.add("수성구");

        times.add(8);
        times.add(10);
        times.add(12);
        times.add(14);
        times.add(16);
        times.add(18);

        doneButton = (Button) findViewById(R.id.doneButton);
        departureSpinner = (Spinner) findViewById(R.id.departureSpinner);
        arrivalSpinner = (Spinner) findViewById(R.id.arrivalSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);

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


                /***********DB**************/
                //버스아이디 찾아서 버스 객체 찾기
                Bus currentBus = new Bus();


                if(currentBus.getCurrentCapacity() >= currentBus.getCapacity()){


                    AlertDialog.Builder failureDialog = new AlertDialog.Builder(Reservation_screen.this);
                    failureDialog.setMessage("예약을 실패하였습니다. .");
                    failureDialog.setPositiveButton("대기 ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            MainActivity.waitings[Waiting.count] = (Waiting) new Waiting();
//                            /**얘네 다 필요 없을 듯
//                             MainActivity.waitings[Waiting.count-1].setTime(time);
//                             MainActivity.waitings[Waiting.count-1].setArrival(arrival);
//                             MainActivity.waitings[Waiting.count-1].setDeparture(departure); **/
//
//                            String waitingCount = Integer.toString(currentBus.getWaitingCount());
//                            MainActivity.waitings[Waiting.count-1].setWaitingCount(Integer.parseInt(waitingCount));

                            /***********DB**************/
                            //디비에 대기 정보 저장

                            /**디비쓰면 얘네 필요 없을수도,,**/
//                            MainActivity.waitings[Waiting.count-1].setBusId(currentBus.id);
//                            currentBus.increaseWaitingCount();
//                            MainActivity.waitings[Waiting.count-1].setUserId(MainActivity.currentUser.getUserID());
                            int waitingCount = 0;



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

//                    MainActivity.reservations[Reservation.count] = new Reservation();
                    /**얘네 다 필요 없을 듯
                     MainActivity.reservations[Reservation.count-1].setArrival(arrival);
                     MainActivity.reservations[Reservation.count-1].setDeparture(departure);
                     MainActivity.reservations[Reservation.count-1].setTime(time);        **/

                    /***********DB**************/
                    //디비에 예매 정보 저장

                    /**디비쓰면 얘네 필요 없을수도,,**/
//                    MainActivity.reservations[Reservation.count-1].setBusId(currentBus.id);
//                    MainActivity.reservations[Reservation.count-1].setUserId(MainActivity.currentUser.getUserID());
//                    currentBus.increaseCurrentCapacity();

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