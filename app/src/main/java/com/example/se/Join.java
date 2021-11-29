package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Join extends AppCompatActivity {
    EditText et_number;
    EditText et_name;
    EditText et_pass;
    EditText et_passck;
    EditText et_email;
    Button btn_register;
    Button btn_cancle;
    Button btn_numck;
    Button btn_emailck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_screen);

        et_number = (EditText)findViewById(R.id.et_number);     //ID
        et_name = (EditText) findViewById(R.id.et_name);        //이름
        et_pass = (EditText) findViewById(R.id.et_pass);        //비밀번호
        et_passck = (EditText) findViewById(R.id.et_passck);    //비밀번호 확인
        et_email = (EditText) findViewById(R.id.et_email);      //E-mail
        btn_register = (Button)findViewById(R.id.btn_register); //회원가입 버튼
        btn_cancle = (Button)findViewById(R.id.btn_cancle);     //취소 버튼
        btn_numck = (Button)findViewById(R.id.btn_numck);       //학번 확인 버튼
        btn_emailck = (Button)findViewById(R.id.btn_emailck);   //email 중복확인 버튼

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number;
                String name;
                String pass;
                String passck;
                String email;

                number = et_number.getText().toString();
                name = et_name.getText().toString();
                pass = et_pass.getText().toString();
                passck = et_passck.getText().toString();
                email = et_email.getText().toString();

                if (name.equals("")||pass.equals("")||passck.equals("")||email.equals("")){
                    Toast.makeText(getApplicationContext(), "공백 부분을 입력해주세요.", Toast.LENGTH_SHORT).show();}
                else if (!(pass.equals(passck))){
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();}
                else if (!(btn_numck.isClickable())){
                    Toast.makeText(getApplicationContext(), "학번확인을 하세요.", Toast.LENGTH_SHORT).show();}
                else if (!(btn_emailck.isClickable())){
                    Toast.makeText(getApplicationContext(), "이메일 중복확인을 하세요.", Toast.LENGTH_SHORT).show();}
                else {
                    Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();}
            }
        });
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}