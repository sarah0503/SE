package com.example.se;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonParse extends AsyncTask<String, Void, String>{
   // String TAG = "JsonParseTest";
    String myJSON ;
   @Override
    protected void onPreExecute() {
        super.onPreExecute();
        myJSON = null;
    }

    public void setMyJSON(String myJSON) {
        this.myJSON = myJSON;
    }

    @Override
    protected String doInBackground(String... strings) {

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
            String r = sb.toString().trim();
            //setMyJSON(r);
            return r;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        //Log.i("###", "|" + s);
        super.onPostExecute(s);
        setMyJSON(s);
    }


    public String getMyJSON() {
        return myJSON;
    }


}
