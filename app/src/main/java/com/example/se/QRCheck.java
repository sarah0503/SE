package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRCheck extends AppCompatActivity {
    int busId = 0 ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent(); intent.getIntExtra("BusId", busId);
        new IntentIntegrator(this).initiateScan();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "다시 스캔해주세요.", Toast.LENGTH_LONG).show();
                // todo
            } else {
                //Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
                String resultStr = result.toString();
                String QRUserId = resultStr.split(",")[1];

                boolean check = false;

                /***********DB**************/
                //check에 true, false값 저장 (문서 참고)

                if(check == true){
                    Toast.makeText(this, "탑승이 확인되었습니다. " , Toast.LENGTH_LONG).show();
                }
                else (check == false){
                    Toast.makeText(this, "예매 내역이 존재하지 않습니다. " , Toast.LENGTH_LONG).show();
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
