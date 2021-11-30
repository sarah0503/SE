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
    Button btn_modifyComplete;
    Button btn_modifyCancle;
    Button btn_modiemailck;
    int check = 0;      //이메일 확인버튼을 했다면 1, 아니면 0
    String email;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_info_screen);

        et_editName = (EditText)findViewById(R.id.et_editName);
        et_editPass = (EditText) findViewById(R.id.et_editPass);
        et_editPassck = (EditText) findViewById(R.id.et_editPassck);
        et_editEmail = (EditText) findViewById(R.id.et_editEmail);
        btn_modiemailck = (Button)findViewById((R.id.btn_modiemailck));
        btn_modifyComplete = (Button)findViewById((R.id.btn_modifyComplete));
        btn_modifyCancle = (Button)findViewById((R.id.btn_modifyCancle));

        email = "";

        btn_modiemailck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String modiemail;
                modiemail = et_editEmail.getText().toString();


                if (modiemail.equals("")){
                    Toast.makeText(getApplicationContext(), "값이 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
                else if (modiemail.equals("email")){         // 같은 이메일이 존재한다.
                    Toast.makeText(getApplicationContext(), "이미 사용중인 이메일입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    check = 1;
                    // DB 에서 이메일을 변경해준다. 추가해야 함
                    Toast.makeText(getApplicationContext(), "확인되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_modifyComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String modiname;
                String modipass;
                String modipassck;

                modiname = et_editName.getText().toString();
                modipass = et_editPass.getText().toString();
                modipassck = et_editPassck.getText().toString();

                if (check != 1){            // 공백이 아니면 등록된 이메일이 존재
                    Toast.makeText(getApplicationContext(), "이메일 확인을 하세요.", Toast.LENGTH_SHORT).show();
                }
                else if (modiname.equals("")||modipass.equals("")||modipassck.equals("")){
                    Toast.makeText(getApplicationContext(), "입력되지 않은 값이 있습니다.", Toast.LENGTH_SHORT).show();
                }
                else if (!modipass.equals(modipassck)){
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "정보가 변경되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        btn_modifyCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}