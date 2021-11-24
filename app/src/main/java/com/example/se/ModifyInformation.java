package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ModifyInformation extends AppCompatActivity {

    EditText et_editName;
    EditText et_editPass;
    EditText et_editPassck;
    EditText et_editEmail;
    Button btn_moidifyComplete;
    Button btn_modifyCancle;

    User user = new User();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_info_screen);

        et_editName = (EditText)findViewById(R.id.et_editName);         // 변경할 이름
        et_editPass = (EditText) findViewById(R.id.et_editPass);        // 변경할 비밀번호
        et_editPassck = (EditText) findViewById(R.id.et_editPassck);    // 비밀번호 확인
        et_editEmail = (EditText) findViewById(R.id.et_email);          // 변경할 이메일

        btn_moidifyComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String modiname;
                String modipass;
                String modipassck;
                String modiemail;
                String loadEail = String.valueOf(user.getEmail());


                modiname = et_editName.getText().toString();
                modipass = et_editPass.getText().toString();
                modipassck = et_editPassck.getText().toString();
                modiemail = et_editEmail.getText().toString();

                if (modiname.equals("")||modipass.equals("")||modipassck.equals("")||modiemail.equals("")){
                    Toast.makeText(getApplicationContext(), "입력된 값이 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else if (modipass.equals(modipassck)){
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else if (modiemail.equals(loadEail)){
                    Toast.makeText(getApplicationContext(), "이미 사용중인 이메일입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    // 정보 변경 해줘야하는디 이걸 못하겠슴
                    // 이름
                    // 비밀번호
                    // 이메일
                    Toast.makeText(getApplicationContext(), "정보가 변경되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_modifyCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Information_screen.class);
                startActivity(intent);
            }
        });
    }
}