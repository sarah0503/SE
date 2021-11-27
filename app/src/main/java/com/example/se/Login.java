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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    // 로그인 구현
    EditText editTextID;            //ID 입력받은거
    EditText editTextPassword;      //Pass 입력받은거
    Button btn_login;               //로그인 버튼
    Button btn_register;            //회원가입 버튼
    Button btn_editpass;            //비밀번호 변경 버튼


    static RequestQueue queue;
    static RequestQueue queue1;
    private  static final String TAG = "RESULT";
    static String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        editTextID = (EditText)findViewById(R.id.editTextID);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_register = (Button)findViewById(R.id.btn_register);
        btn_editpass = (Button)findViewById(R.id.btn_editpass);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id;                                          // DB에서 가져오는 ID이면 이게 int로 둬야하는지 String으로 둬야하는지..?
                String pass;
                id = editTextID.getText().toString();
                pass = editTextPassword.getText().toString();


                if (id.equals("")||pass.equals("")){
                    Toast.makeText(getApplicationContext(), "입력된 값이 없습니다.", Toast.LENGTH_SHORT).show();
                }

                boolean error = false;
                for(int i = 0; i<User.user_count ; i++){
                    if(Join.users[i].checkId(id) == true){
                        error = true;
                        if(Join.users[i].isCorrect(pass) == true){
                            Intent intent = new Intent(getApplicationContext(), Home_screen.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "일치하지 않는 비밀번호 입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                if(error == false){
                    Toast.makeText(getApplicationContext(), "등록되지 않은 아이디입니다.", Toast.LENGTH_SHORT).show();
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