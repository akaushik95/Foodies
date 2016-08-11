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
// * Created by ashukaushik on 07/07/16.
// */
//public class CategoryDownloadTask extends AsyncTask<String, Void, Category[]> {
//    MainActivity mActivity;
//
//    public CategoryDownloadTask(MainActivity activity) {
//        mActivity = activity;
//    }
//
//    private Category[] parseJson(String json) {
//        try {
//            JSONObject obj = new JSONObject(json);
//            JSONArray categories = obj.getJSONArray("categories");
//            Category[] output = new Category[categories.length()];
//            for (int i = 0; i < categories.length(); i++) {
//                JSONObject categoriesJSONObject = categories.getJSONObject(i);
//                JSONObject obj1=categoriesJSONObject.getJSONObject("categories");
//                String name = obj1.getString("name");
//                int id = obj1.getInt("id");
//                output[i] = new Category(name, id);
//            }
//            return output;
//        } catch (JSONException e) {
//            return null;
//        }
//    }
//
//    @Override
//    protected Category[] doInBackground(String... params) {
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
//    protected void onPostExecute(Category[] categories) {
//        super.onPostExecute(categories);
//        mActivity.processResult(categories);
//    }
//}
