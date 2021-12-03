package com.example.se;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRIssue extends AppCompatActivity {
    String contents;
    ImageView qrImage;
    public static Bitmap issueQR(String contents){
        Bitmap bitmap = null;
        try{
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            bitmap = toBitmap(qrCodeWriter.encode(contents, BarcodeFormat.QR_CODE, 200,200));
        }catch (WriterException e){
            e.printStackTrace();
        }
        return bitmap;
    }
    private static Bitmap toBitmap(BitMatrix matrix) {
        int height = matrix.getHeight();
        int width = matrix.getWidth();
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bmp.setPixel(x, y, matrix.get(x, y) ? Color.BLACK : Color.WHITE);
            }
        }
        return bmp;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_issue_screen);

        qrImage = (ImageView) findViewById(R.id.qrImage);
        //String Userid = currentUser.getId();
        /***********DB**************/
        //contents 에 'busId' + ',' + 'userId' 이렇게 저장되어야 됨 (구분자 필요!)
        contents = "temp"; //여기 정보 저장해야함

        Bitmap bitmap = issueQR(contents);
        qrImage.setImageBitmap(bitmap);
    }
}
