package com.example.ashukaushik.foodies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class categoryActivity extends AppCompatActivity {
    ArrayList<restaurantResponse.restaurant> a;
    restaurantAdapter restaurantAdapter;
    ListView crlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        int s=getIntent().getIntExtra("categoryid",0);
        String s1=getIntent().getStringExtra("enid");
        String s2=getIntent().getStringExtra("def");
        crlv=(ListView) findViewById(R.id.categoryrestaurantlv);
        a=new ArrayList<>();

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://developers.zomato.com/api/v2.1/").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();
        final categoryRestaurantInterface categoryrestaurantinterface=retrofit.create(categoryRestaurantInterface.class);
        Call<restaurantResponse> call=categoryrestaurantinterface.getcatRest(s1,s2,s,"39c74c0e0815c8fedc0eb526081a2d40");
        call.enqueue(new Callback<restaurantResponse>() {
            @Override
            public void onResponse(Call<restaurantResponse> call, Response<restaurantResponse> response) {
                restaurantResponse obj= response.body();
                if(obj.getRestaurants().size()==0){
                    return;
                }
                a.clear();
                for(int i=0;i<obj.getRestaurants().size();i++){
                    a.add(obj.getRestaurants().get(i).getRestaurant());
                }
                restaurantAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<restaurantResponse> call, Throwable t) {

            }
        });

        restaurantAdapter=new restaurantAdapter(this,a);
        crlv.setAdapter(restaurantAdapter);
//        call.enqueue(new Callback<restaurantInterface>() {
//            @Override
//            public void onResponse(Call<restaurantInterface> call, Response<restaurantInterface> response) {
//                restaurantResponse obj= response.body();
//                if(obj.getRestaurants().size()==0){
//                    return;
//                }
//                a.clear();
//                for(int i=0;i<obj.getRestaurants().size();i++){
//                    a.add(obj.getRestaurants().get(i).getRestaurant());
//                }
//                restaurantAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<restaurantInterface> call, Throwable t) {
//
//            }
//        });
//        categoryRestaurantDownloadTask crdt=new categoryRestaurantDownloadTask(categoryActivity.this);
//        if(s1==null){
//            crdt.execute("https://developers.zomato.com/api/v2.1/search?entity_type=subzone&category="+s+"&apikey=39c74c0e0815c8fedc0eb526081a2d40");
//        }else{
//            crdt.execute("https://developers.zomato.com/api/v2.1/search?entity_id="+s1+"&entity_type=subzone&category="+s+"&apikey=39c74c0e0815c8fedc0eb526081a2d40");
//        }
//


    }
//    public void processCategoryResultrestaurant(restaurant[] restaurants){
//        if(restaurants==null){
//            return;
//        }
//        a.clear();
//        for(restaurant res:restaurants){
//            a.add(res);
//        }
//        restaurantAdapter.notifyDataSetChanged();
//    }
}
