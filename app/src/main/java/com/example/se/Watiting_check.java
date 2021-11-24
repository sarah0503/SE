package com.example.se;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

// 이거 못하겠는디
// 예약내역이 대기 현황 버튼이다.
// 사용자의 대기 내역을 확인할 수 있게 해야하는거니까...
public class Watiting_check {
    //버스 아이디, 사용자 아이디, 대기번호, 출발지, 도착지, 시간 정보를 가져와야함 Waiting에서
    //  사용자의 ID의 정보를 가진 예약 내역을 불러온다.

    User user = new User();
    int userID = user.getId();
    Waiting waiting = new Waiting();
    int waitUserID = waiting.getUserId();
//    Waiting a = new Waiting();        // ?
//    int busId = a.getBusId();
//    int count = a.getWaitingId();
//    String arrival = a.getArrival();
//    String departure = a.getDeparture();
//    int time = a.getTime();

    public int getWaitUserID() { return waitUserID; }
    public int getUserID(){ return userID; }

    ArrayList<Object> waitinglist = new ArrayList<Object>();
}
