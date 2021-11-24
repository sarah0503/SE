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

public class Login extends AppCompatActivity {

    // 로그인 구현
    EditText editTextID;            //ID 입력받은거
    EditText editTextPassword;      //Pass 입력받은거
    Button btn_login;               //로그인 버튼
    Button btn_register;            //회원가입 버튼
    Button btn_editpass;            //비밀번호 변경 버튼

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        editTextID = (EditText)findViewById(R.id.editTextID);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_register = (Button)findViewById(R.id.btn_register);
        btn_editpass = (Button)findViewById(R.id.btn_editpass);

        User user = new User();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              int check = 0;                                      // 없어도 될것 같기두..) DB에서 동일한 아이디를 찾으면 1, 아니면 0
                String id;                                          // DB에서 가져오는 ID이면 이게 int로 둬야하는지 String으로 둬야하는지..?
                String pass;
                id = editTextID.getText().toString();
                pass = editTextPassword.getText().toString();
                String loadId = String.valueOf(user.getId());       //보류) DB에서 입력받은 ID와 동일한 것이 있으면 Pass 불러와야함
                String loadPass = String.valueOf(user.getPassword());


                if (id.equals("")||pass.equals("")){
                    Toast.makeText(getApplicationContext(), "입력된 값이 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else if (!loadId.equals("")){        //공백이 아니라면 동일한 것이 있을것이다....~?
//                  check = 1;
                    if (pass.equals(loadPass)){
                        Toast.makeText(getApplicationContext(), "로그인되었습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Home_screen.class);
                        startActivity(intent);
                    }
                }
                else if (loadId.equals("")){
                    Toast.makeText(getApplicationContext(), "로그인 정보가 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join.class);
                startActivity(intent);
            }
        });

        btn_editpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindPassword.class);
                startActivity(intent);
            }
        });

    }
}