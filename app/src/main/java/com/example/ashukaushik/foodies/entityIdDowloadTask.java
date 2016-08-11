//package com.example.ashukaushik.foodies;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//import java.util.Scanner;
//
///**
// * Created by ashukaushik on 08/07/16.
// */
//public class entityIdDowloadTask extends AsyncTask<String,Void,String>{
//    MainActivity mActivity;
//
//    public entityIdDowloadTask(MainActivity activity) {
//        mActivity = activity;
//    }
//
//    private String parseJson(String json) {
//        try {
//            JSONObject obj = new JSONObject(json);
//            JSONArray location = obj.getJSONArray("location_suggestions");
//            String id=location.getJSONObject(0).getString("entity_id");
//            return id;
//        } catch (JSONException e) {
//            return null;
//        }
//    }
//    @Override
//    protected String doInBackground(String... params) {
//        if (params.length == 0)
//            return null;
//
//        StringBuffer buffer = new StringBuffer();
//        try {
//            URL url = new URL(params[0]);
//            HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
//
//            urlConnection.setRequestMethod("GET");
//            urlConnection.connect();
//            InputStream inputStream =
//                    urlConnection.getInputStream();
//            if (inputStream == null) {
//                return null;
//            }
//            Scanner s = new Scanner(inputStream);
//            while (s.hasNext()) {
//                buffer.append(s.nextLine());
//            }
//            Log.i("jsondata", buffer.toString());
//        } catch (MalformedURLException e) {
//            return null;
//        } catch (ProtocolException e) {
//            return null;
//        } catch (IOException e) {
//            return null;
//        }
//        return parseJson(buffer.toString());
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//        mActivity.processResultid(s);
//    }
//}
