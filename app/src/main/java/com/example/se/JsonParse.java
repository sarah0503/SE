package com.example.se;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonParse extends AsyncTask<String, Void, String>{
    String TAG = "JsonParseTest";
    String myJSON ;

    public String getMyJSON() {
        return myJSON;
    }


    @Override
    protected String doInBackground(String... strings) {
//        String url = strings[0];
//        try{
//            URL serverURL = new URL(url);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) serverURL.openConnection();
//
//            httpURLConnection.setReadTimeout(5000);
//            httpURLConnection.setConnectTimeout(5000);
//            httpURLConnection.connect();
//
//            int responseStatusCode = httpURLConnection.getResponseCode();
//
//            InputStream inputStream;
//            if(responseStatusCode == HttpURLConnection.HTTP_OK){
//                inputStream = httpURLConnection.getInputStream();
//            }
//            else{
//                inputStream = httpURLConnection.getErrorStream();
//            }
//
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            StringBuilder sb = new StringBuilder();
//            String line;
//
//            while((line = bufferedReader.readLine()) != null){
//                sb.append(line);
//            }
//
//            bufferedReader.close();
//            Log.d(TAG, sb.toString().trim());
//
//            return sb.toString().trim();
//
//        }catch (Exception e){
//            Log.d(TAG, "InsertData : Error", e);
//            String errorString = e.toString();
//            return null;
//        }
        String uri = strings[0];
        BufferedReader bufferedReader = null;
        try{
            URL url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb =new StringBuilder();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));


            String json;
            while ((json = bufferedReader.readLine()) != null){
                sb.append(json + "\n");
            }
            return sb.toString().trim();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        myJSON = s;
    }
}
