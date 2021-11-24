package com.example.se;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class EditLine extends AppCompatActivity {

    private Bus bus;
    //private ArrayList departure, stop1, stop2, stop3, arrival;
    //private ArrayAdapter<String> departureAdapter, stop1Adapter, stop2Adaptor, stop3Adaptor, arrivalAdaptor;
    private EditText editDeparture, editStop1, editStop2, editStop3, editArrival, editTime;
    private Button cancelButton, addButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_line_screen);


        editDeparture = findViewById(R.id.editDeparture);
        editStop1 = findViewById(R.id.editStop1);
        editStop2 = findViewById(R.id.editStop2);
        editStop3 = findViewById(R.id.editStop3);
        editArrival = findViewById(R.id.editArrival);
        editTime = findViewById(R.id.editTime);

        cancelButton = findViewById(R.id.editCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addButton = findViewById(R.id.editAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus = new Bus();
                bus.setDeparture(editDeparture.getText().toString());
                bus.setStop1(editStop1.getText().toString());
                bus.setStop2(editStop2.getText().toString());
                bus.setStop3(editStop3.getText().toString());
                bus.setArrival(editArrival.getText().toString());
                bus.setDepartureTime(Integer.parseInt(editTime.getText().toString()));

                //수정 내용 저장하기
            }
        });

    }
}
