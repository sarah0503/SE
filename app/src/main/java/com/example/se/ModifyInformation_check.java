package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ModifyInformation_check extends AppCompatActivity {

    EditText et_pass;
    Button btn_ok;
    Button btn_back;

    User user = new User();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_info_check);

        et_pass = (EditText)findViewById(R.id.et_pass);     // 사용자아이디의 비밀번호
        btn_ok = (Button) findViewById(R.id.btn_ok);        // 확인 버튼
        btn_back = (Button) findViewById(R.id.btn_back);    // 이전화면으로 돌아가기 버튼

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass;
                pass = et_pass.getText().toString();
                String loadPass = String.valueOf(user.getPassword());       // DB 에서 사용자 ID 정보와 일치하는 비밀번호 불러오기

                if (pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "값이 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals(loadPass)) {       // 사용자가 입력한 값과 로드한 비밀번호가 같은 경우
                    Toast.makeText(getApplicationContext(), "확인되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ModifyInformation.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "일치하지 않는 정보입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       // 내정보 창으로 가기
                Intent intent = new Intent(getApplicationContext(), Information_screen.class);
                startActivity(intent);
            }
        });

    }

}
