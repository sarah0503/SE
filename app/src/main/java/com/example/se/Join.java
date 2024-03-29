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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

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


    static RequestQueue queue;
    private  static final String TAG = "RESULT";

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

        User user = new User();

        btn_numck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number;
                number = et_number.getText().toString();
                String loadId = String.valueOf(user.getId());           //DB에서 number와 동일한 ID가 있으면 로드

                if (number.equals("")){
                    Toast.makeText(getApplicationContext(), "입력된 값이 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else if (et_number.equals(loadId)){
                    Toast.makeText(getApplicationContext(), "이미 등록된 사용자입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "확인되었습니다.", Toast.LENGTH_SHORT).show();
                    //해당 학번(ID)을 저장해야함
                }
            }
        });

        btn_emailck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loademail = String.valueOf(user.getEmail());
                String email;
                email = et_email.getText().toString();

                if (email.equals("")){
                    Toast.makeText(getApplicationContext(), "입력된 값이 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else if (email.equals(loademail)){
                    Toast.makeText(getApplicationContext(), "이미 사용중인 이메일입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "확인되었습니다.", Toast.LENGTH_SHORT).show();
                    //해당 email 을 저장해야함
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number;
                String name;
                String pass;
                String passck;
                String email;
                String manager = "0";

                number = et_number.getText().toString();
                name = et_name.getText().toString();
                pass = et_pass.getText().toString();
                passck = et_passck.getText().toString();
                email = et_email.getText().toString();


                if (queue != null) {
                    queue.cancelAll(TAG);
                }

                if (name.equals("")||pass.equals("")||passck.equals("")||email.equals("")){
                    Toast.makeText(getApplicationContext(), "공백 부분을 입력해주세요.", Toast.LENGTH_SHORT).show();}
//                else if (!(pass.equals(passck))){
//                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();}
//                else if (!(btn_numck.isClickable())){
//                    Toast.makeText(getApplicationContext(), "학번확인을 하세요.", Toast.LENGTH_SHORT).show();}
//                else if (!(btn_emailck.isClickable())){
//                    Toast.makeText(getApplicationContext(), "이메일 중복확인을 하세요.", Toast.LENGTH_SHORT).show();}
                else {
                    //학번(ID), Password, 이름, email 을 저장해야함

                    String addURL = ("http://yubusin.dothome.co.kr/join_insert.php");

                    if(queue == null) {
                        try {
                            queue = Volley.newRequestQueue(Join.this);
                        }catch (Exception e){ e.printStackTrace();}
                    }

                    StringRequest request = new StringRequest(Request.Method.POST, addURL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
//                        try
                        }
                    }, new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }

                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("number", number);
                            params.put("name", name);
                            params.put("pass", pass);
                            params.put("email", email);
                            params.put("manager", manager);
                            return params;

                        }
                    };
                    request.setTag(TAG);

                    queue.add(request);

                    Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
                if (queue != null) {
                    queue.cancelAll(TAG);
                }

            }
        });
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "회원가입이 취소되었습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}