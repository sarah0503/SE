package com.example.se;

public class PenaltyActivity {
    Penalty p = new Penalty();

    int userID = p.getUserID();                         // UserID에 등록된 패널티 값을 불러와야함
    int penalty_count = p.getPenaltyCount();                  // Penalty 값을 불러와야함
    int penalty_date = p.getPenalty_date();              // Penalty_date 값 불러와야함
    Boolean reservationBoolean = p.getReservationBoolean();         // reservationBoolean 값을 DB 에서 불러와야함(예약이 가능한지 아닌지를 boolean 으로 표현)

    void penaltyCountDay() {
        if (penalty_date == 0) {
            //해당 사용자의 정보에서 값 바뀐거 저장
            penalty_date = 10;
            penalty_count = 0;
            reservationBoolean = Boolean.TRUE; //이게 맞는지 모르겠다
        } else
            //해당 사용자의 정보에서 값 바뀐거 저장
            penalty_date--;
    }

    void penaltyIncrese(int penalty_count) {
        if (penalty_count < 3)
            //해당 사용자의 정보에서 값 바뀐거 저장
            penalty_count++;
        else if (penalty_count == 3) {
            //해당 사용자의 정보에서 값 바뀐거 저장
//            penalty_count = 0;
            reservationBoolean = Boolean.FALSE;
            penalty_date = 10;
            penaltyCountDay();
        }
    }
}