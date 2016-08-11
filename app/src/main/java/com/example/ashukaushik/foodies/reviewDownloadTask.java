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
// * Created by ashukaushik on 11/07/16.
// */
//public class reviewDownloadTask extends AsyncTask<String,Void,reviews[]> {
//
//    reviewActivity mActivity;
//
//    public reviewDownloadTask(reviewActivity activity) {
//        mActivity = activity;
//    }
//
//
//
//    private reviews[] parseJson(String json) {
//        try {
//            JSONObject obj = new JSONObject(json);
//            JSONArray userreviews = obj.getJSONArray("user_reviews");
//            reviews[] output=new reviews[userreviews.length()];
//            for(int i=0;i<userreviews.length();i++){
//                JSONObject restaurantJSONObject=userreviews.getJSONObject(i);
//                JSONObject obj1=restaurantJSONObject.getJSONObject("review");
//                String text=obj1.getString("review_text");
//                String rating=obj1.getString("rating_text");
//                output[i]=new reviews(text,rating);
//            }
//            return output;
//
//        } catch (JSONException e) {
//            return null;
//        }
//    }
//    @Override
//    protected reviews[] doInBackground(String... params) {
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
//    protected void onPostExecute(reviews[] reviews) {
//        super.onPostExecute(reviews);
//        mActivity.processResultReview(reviews);
//    }
//}
