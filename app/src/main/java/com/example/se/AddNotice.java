package com.example.se;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AddNotice extends AppCompatActivity {

    private Button noticeInputButton;
    private EditText inputTitleEditText;
    private EditText inputContentEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_notice_screen);

        JsonParse insert = new JsonParse();
        insert.execute("http://yubusin.dothome.co.kr/addnotice_insert.php");

        noticeInputButton = findViewById(R.id.noticeInputButton);
        inputTitleEditText = findViewById(R.id.inputTitleEditText);
        inputContentEditText = findViewById(R.id.inputContentEditText);

        noticeInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notice notice = new Notice();
                notice.setTitle(inputTitleEditText.getText().toString());
                notice.setContent(inputContentEditText.getText().toString());
                //notice.setDate(); 당일 날짜 저장



                //완료 버튼 누르면 입력한 내용 저장하기



                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                Toast.makeText(builder.getContext(), "완료되었습니다.", Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }
}
