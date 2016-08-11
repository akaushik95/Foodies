package com.example.ashukaushik.foodies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class restaurantActivity extends AppCompatActivity {
    ListView reslv;
    ArrayList<restaurantResponse.restaurant> a;
    restaurantAdapter restaurantAdapter;
    String idnew,typenew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        reslv=(ListView)findViewById(R.id.restaurantListView);
        a=new ArrayList<>();
        idnew=getIntent().getStringExtra("abc");
        typenew=getIntent().getStringExtra("citytype");
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://developers.zomato.com/api/v2.1/").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();
        final restaurantInterface restaurantinterface=retrofit.create(restaurantInterface.class);
        Call<restaurantResponse> call = restaurantinterface.getRest(idnew,typenew,"39c74c0e0815c8fedc0eb526081a2d40");
        call.enqueue(new Callback<restaurantResponse>() {
            @Override
            public void onResponse(Call<restaurantResponse> call, Response<restaurantResponse> response) {
                restaurantResponse obj=response.body();
                if(obj.getRestaurants().size()==0){
                    Toast.makeText(restaurantActivity.this,"No restaurants found",Toast.LENGTH_SHORT).show();
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
        reslv.setAdapter(restaurantAdapter);

//        restaurantDownloadTask rdt=new restaurantDownloadTask(restaurantActivity.this);
//        rdt.execute("https://developers.zomato.com/api/v2.1/search?entity_id="+idnew+"&entity_type=subzone&apikey=39c74c0e0815c8fedc0eb526081a2d40");
//        restaurantAdapter=new restaurantAdapter(this,a);
//        reslv.setAdapter(restaurantAdapter);
        reslv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent x=new Intent();
                x.setClass(restaurantActivity.this,reviewActivity.class);
                restaurantResponse.restaurant clickedRestaurant=(restaurantResponse.restaurant) adapterView.getAdapter().getItem(i);
                x.putExtra("resid",clickedRestaurant.getResId());
                startActivity(x);
            }
        });
    }



//    public void processResultrestaurant(restaurant[] restaurants){
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
