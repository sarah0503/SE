package com.example.se;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Reservation_screen extends AppCompatActivity {
    Spinner placeSpinner, timeSpinner;
    Button doneButton;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resevation_screen);

        doneButton = (Button) findViewById(R.id.doneButton);
        placeSpinner = (Spinner) findViewById(R.id.placeSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);
        ArrayList<String> places = new ArrayList <String> ();
        //String places[] = new String[100];
        int place_count = 0;
        ArrayList<Integer> times = new ArrayList <Integer>();
        int count = Bus.count;
        /****/
        Bus a = new Bus();
        a.setArrival("집");
        a.setDapartureTime(8);
        Bus b = new Bus();
        b.setArrival("학교");
        b.setDapartureTime(10);
       // for(int i = 0; i<count; i++){
            places.add(a.getArrival());
           // places[place_count] = a.getArrival();
            //place_count++;
            times.add(a.getDapartureTime());
            places.add(b.getArrival());
           // places[place_count] = b.getArrival();
            times.add(b.getDapartureTime());

      //  }
        ArrayAdapter<String> placeAdpater = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                places);
        placeSpinner.setAdapter(placeAdpater);

        ArrayAdapter<Integer> timeAdapter = new ArrayAdapter<Integer>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                times);
        timeSpinner.setAdapter(timeAdapter);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버스아이디 찾아서 버스 객체 찾기
                Bus currentBus = new Bus();

                int time;
                String place;
                place = placeSpinner.getSelectedItem().toString();
                time = Integer.parseInt(timeSpinner.getSelectedItem().toString());

                if(currentBus.getCurrentCapacity() >= currentBus.capacity){


                    AlertDialog.Builder failureDialog = new AlertDialog.Builder(Reservation_screen.this);
                    failureDialog.setMessage("예약을 실패하였습니다. .");
                    failureDialog.setPositiveButton("대기 ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.waitings[Waiting.count] = (Waiting) new Waiting();
                            MainActivity.waitings[Waiting.count-1].setTime(time);
                            MainActivity.waitings[Waiting.count-1].setPlace(place);
                            MainActivity.waitings[Waiting.count-1].setBusId(currentBus.id);
                            currentBus.increaseWaitingCount();
                            //    MainActivity.waitings[Waiting.count-1].setUserId(currnetUser);
                            //    currentUser.addWaiting(MainActivity.waitings[Waiting.count-1]);
                            String waitingCount = Integer.toString(currentBus.getWaitingCount());
                            Toast.makeText(getApplicationContext(), waitingCount,Toast.LENGTH_LONG).show();
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
                    MainActivity.reservations[Reservation.count-1].setPlace(place);
                    MainActivity.reservations[Reservation.count-1].setTime(time);
                    MainActivity.reservations[Reservation.count-1].setBusId(currentBus.id);
                    //  MainActivity.reservations[Reservation.count-1].setUserId(currnetUser);
                    //  currentUser.addReservation(MainActivity.reservations[Reservation.count-1]);
                    currentBus.increaseCurrentCapacity();

                    AlertDialog.Builder reservationDialog = new AlertDialog.Builder(Reservation_screen.this);
                    reservationDialog.setMessage("예약이 완료되었습니다. ");
                    reservationDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                }//예약 성공
            }
        });


    }
}
