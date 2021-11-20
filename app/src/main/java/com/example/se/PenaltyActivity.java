package com.example.se;

public class PenaltyActivity {
    int penalty_count;
    int penalty_date = 10; // 10일 동안 예약 못하는거였나?
    Boolean reservationBoolean; // 예약이 가능한지 아닌지를 boolean으로 표현

    void penaltyCountDay() {
        if(this.penalty_date==0){
            this.penalty_date=10;
            this.reservationBoolean = Boolean.TRUE; //이게 맞는지 모르겠다
        }
        else
            this.penalty_date--;
    }
    void penaltyIncrese(int penalty_count){
        if(penalty_count<3)
            this.penalty_count++;
        else {
            this.penalty_count = 0;
            this.reservationBoolean = Boolean.FALSE;
            penaltyCountDay();
        }
    }
}