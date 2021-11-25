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
    Spinner arrivalSpinner, departureSpinner, timeSpinner;
    Button doneButton;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_screen);

        doneButton = (Button) findViewById(R.id.doneButton);
        departureSpinner = (Spinner) findViewById(R.id.departureSpinner);
        arrivalSpinner = (Spinner) findViewById(R.id.arrivalSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);
        /***********DB**************/
        ArrayList<String> arrivals = new ArrayList <String> ();
        ArrayList<String> departures = new ArrayList <String> ();
        //String places[] = new String[100];
        int place_count = 0;
        ArrayList<Integer> times = new ArrayList <Integer>();
        int count = Bus.count;

        /**임시**/
        Bus a = new Bus();
        a.setArrival("집");
        a.setDepartureTime(8);
        Bus b = new Bus();
        b.setArrival("학교");
        b.setDepartureTime(10);
       // for(int i = 0; i<count; i++){
            arrivals.add(a.getArrival());
           // places[place_count] = a.getArrival();
            //place_count++;
            times.add(a.getDepartureTime());
            arrivals.add(b.getArrival());
           // places[place_count] = b.getArrival();
            times.add(b.getDepartureTime());
        /**임시**/
      //  }
        ArrayAdapter<String> arrivalAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                arrivals);
        arrivalSpinner.setAdapter(arrivalAdapter);

        ArrayAdapter<String> departureAdpater = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                arrivals);
        departureSpinner.setAdapter(departureAdpater);

        ArrayAdapter<Integer> timeAdapter = new ArrayAdapter<Integer>(
                getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                times);
        timeSpinner.setAdapter(timeAdapter);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int time;
                String arrival;
                String departure;
                arrival = arrivalSpinner.getSelectedItem().toString();
                departure = departureSpinner.getSelectedItem().toString();
                time = Integer.parseInt(timeSpinner.getSelectedItem().toString());

                /***********DB**************/
                //버스아이디 찾아서 버스 객체 찾기
                Bus currentBus = new Bus();

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
