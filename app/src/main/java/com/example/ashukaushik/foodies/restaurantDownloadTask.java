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
//public class restaurantDownloadTask extends AsyncTask<String,Void,restaurant[]>{
//    restaurantActivity mActivity;
//
//    public restaurantDownloadTask(restaurantActivity activity) {
//        mActivity = activity;
//    }
//
//
//
//    private restaurant[] parseJson(String json) {
//        try {
//            JSONObject obj = new JSONObject(json);
//            JSONArray restaurants = obj.getJSONArray("restaurants");
//            restaurant[] output=new restaurant[restaurants.length()];
//            for(int i=0;i<restaurants.length();i++){
//                JSONObject restaurantJSONObject=restaurants.getJSONObject(i);
//                JSONObject obj1=restaurantJSONObject.getJSONObject("restaurant");
//                JSONObject addressJSONObject=obj1.getJSONObject("location");
//                String resid=obj1.getString("id");
//                String name=obj1.getString("name");
//                String image=obj1.getString("featured_image");
//                String cuisines=obj1.getString("cuisines");
//                String cost=obj1.getString("average_cost_for_two");
//                String address=addressJSONObject.getString("address");
//                output[i]=new restaurant(name,address,image,cuisines,cost,resid);
//            }
//            return output;
//
//        } catch (JSONException e) {
//            return null;
//        }
//    }
//    @Override
//    protected restaurant[] doInBackground(String... params) {
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
//    protected void onPostExecute(restaurant[] restaurants) {
//        super.onPostExecute(restaurants);
//        mActivity.processResultrestaurant(restaurants);
//    }
//}
