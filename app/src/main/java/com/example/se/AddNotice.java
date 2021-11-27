package com.example.se;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

public class AddNotice extends AppCompatActivity {

    private Button noticeInputButton;
    private EditText inputTitleEditText;
    private EditText inputContentEditText;

    static RequestQueue queue;
    private  static final String TAG = "RESULT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_notice_screen);


        noticeInputButton = findViewById(R.id.noticeInputButton);
        inputTitleEditText = findViewById(R.id.inputTitleEditText);
        inputContentEditText = findViewById(R.id.inputContentEditText);

        noticeInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notice notice = new Notice();
                notice.setTitle(inputTitleEditText.getText().toString());
                notice.setContent(inputContentEditText.getText().toString());

                String addURL = ("http://yubusin.dothome.co.kr/addnotice_insert.php");

                if(queue == null) {
                    try {
                        queue = Volley.newRequestQueue(AddNotice.this);
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
                        params.put("id", "1");
                        params.put("title", inputTitleEditText.getText().toString());
                        params.put("content", inputContentEditText.getText().toString());
                        return params;

                    }
                };
                request.setTag(TAG);

                //notice.setDate(); 당일 날짜 저장

                queue.add(request);


                //완료 버튼 누르면 입력한 내용 저장하기



                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                Toast.makeText(builder.getContext(), "완료되었습니다.", Toast.LENGTH_LONG).show();

                //finish();
            }
        });
    }
}
