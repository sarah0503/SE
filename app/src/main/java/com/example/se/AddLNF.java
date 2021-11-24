package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddLNF extends AppCompatActivity {

    private EditText lnfTitle;
    private ImageView imageView;
    private EditText lnfExplain;
    private Button lnfSaveButton;

    LNF lnf = new LNF();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_lnf_screen);

        lnfTitle = findViewById(R.id.lnfTitleEditText);
        imageView = findViewById(R.id.lnfImageView);
        lnfExplain = findViewById(R.id.lnfExplainEditText);
        lnfSaveButton = findViewById(R.id.lnfSaveButton);

        tedPermission();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 갤러리에서 이미지 가져와서 추가하기

            }
        });

        lnfSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lnf.setTitle(lnfTitle.getText().toString());
                //lnf.setImage(imageView.getImage....)
                lnf.setExplain(lnfExplain.getText().toString());



                // 입력한 내용 저장하기



                finish();   //저장하기 누르면 저장 후 이전 화면으로 돌아감
            }
        });
    }

    private void tedPermission() { // 갤러리 권한 허용

    }
}
