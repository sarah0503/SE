package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import java.util.Objects;

public class FindPassword extends AppCompatActivity {

    String number;          //DB에 저장된 학번을 불러와야함 ? 이걸 어떻게 해야할까...?
    EditText et_id;         //DB에 et_id와 동일한 것이 있는지 찾아서 number에 저장해야할거 같음
    String pass;            //DB에서 해당 학번의 비밀번호를 불러와야함
    EditText et_chPass;
    Button btn_idCheck;
    Button btn_chPass;
    int check = 0;      //학번이 확인되었는지 아닌지 구별하는 변수

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_password_screen);

        et_id = (EditText) findViewById(R.id.et_id);
        et_chPass = (EditText) findViewById(R.id.et_chPass);
        btn_idCheck = (Button) findViewById(R.id.btn_idCheck);
        btn_chPass = (Button) findViewById(R.id.btn_chPass);


        btn_idCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id;
                id = et_id.getText().toString();

                if (id.equals("")){
                    Toast.makeText(getApplicationContext(), "ID에 입력된 값이 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else if (!id.equals("")){
//                    String loadID = String.valueOf(number);       //DB 에서 해당 ID와 동일한것이 있으면 가져오기
                    if (id.equals("fail")){
                        Toast.makeText(getApplicationContext(), "존재하지 않는 사용자입니다.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "학번이 확인되었습니다.", Toast.LENGTH_SHORT).show();
                        check = 1;
                    }
                }
            }
        });
        btn_chPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chPass;
                chPass = et_chPass.getText().toString();
                if (chPass.equals("")){
                    Toast.makeText(getApplicationContext(), "입력된 값이 없습니다.", Toast.LENGTH_SHORT).show(); }
                else if (check == 1){
                    Toast.makeText(getApplicationContext(), "비밀번호가 변경되었습니다.", Toast.LENGTH_SHORT).show();
                    //DB에 해당 학번의 비밀번호를 변경
                    Intent intent = new Intent(getApplicationContext(), Home_screen.class);
                    startActivity(intent);                     // 메인화면으로 이동
                }
                else if (check == 0){
                    Toast.makeText(getApplicationContext(), "학번을 확인하세요.", Toast.LENGTH_SHORT).show(); }
            }
        });
    }
}