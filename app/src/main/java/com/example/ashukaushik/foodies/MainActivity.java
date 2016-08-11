package com.example.ashukaushik.foodies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    GridView categorygv;
    SearchView cityet;
    Button searchb,checkb;
    categoryAdapter adapter;
    ArrayList<CategoriesResponse.Category> c;
    String id,type,cname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categorygv=(GridView)findViewById(R.id.categoryGridView);
        cityet=(SearchView) findViewById(R.id.cityEditText);
        searchb=(Button)findViewById(R.id.searchButton);
        c=new ArrayList<>();
//        CategoryDownloadTask ctk=new CategoryDownloadTask(this);
//        ctk.execute("https://developers.zomato.com/api/v2.1/categories?apikey="+ApiKey.KEY);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://developers.zomato.com/api/v2.1/").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();
        final categoryInterface categoryinterface=retrofit.create(categoryInterface.class);
        Call<CategoriesResponse> call = categoryinterface.getCategory("39c74c0e0815c8fedc0eb526081a2d40");
        call.enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                CategoriesResponse obj=response.body();
                if(obj.getCategories().size()==0){
                    return;
                }
                c.clear();
                for(int i=0;i<obj.getCategories().size();i++){
                    c.add(obj.getCategories().get(i).getCategory());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {

            }
        });
        adapter=new categoryAdapter(this,c);
        categorygv.setAdapter(adapter);
        cityet.setQueryHint("city");
        searchb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityet.setQuery(cityet.getQuery(),true);
//                entityIdDowloadTask eitk=new entityIdDowloadTask(MainActivity.this);
                String cityName = cityet.getQuery().toString();
                try {
                    cityName=URLEncoder.encode(cityName,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                //cityName = cityName.replace(" ", "%20");
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://developers.zomato.com/api/v2.1/").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();
                final entityInterface entityinterface=retrofit.create(entityInterface.class);
                Call<entityResponse> call = entityinterface.getEntity(cityName,"39c74c0e0815c8fedc0eb526081a2d40");
                call.enqueue(new Callback<entityResponse>() {
                    @Override
                    public void onResponse(Call<entityResponse> call, Response<entityResponse> response) {
                        if(response.body().getLocations().size()==0){

                        }
                        else{
                            id=response.body().getLocations().get(0).getEntityId().toString();
                            type=response.body().getLocations().get(0).getEntityType().toString();
                            cname=response.body().getLocations().get(0).getCountryName().toString();
                        }
                        if(id!=null && type!=null && cname.compareTo("India")==0){
                            Intent i=new Intent();
                            Toast.makeText(MainActivity.this,"match found",Toast.LENGTH_LONG).show();
                            i.setClass(MainActivity.this,restaurantActivity.class);
                            i.putExtra("abc",id);
                            i.putExtra("citytype",type);
                            i.putExtra("cn",cname);
                            startActivity(i);
                        }else{
                            Toast.makeText(MainActivity.this,"not found",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<entityResponse> call, Throwable t) {

                    }
                });


            }
        });



        categorygv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1=new Intent();
                i1.setClass(MainActivity.this,categoryActivity.class);
                CategoriesResponse.Category clickedCategory = (CategoriesResponse.Category) adapterView.getAdapter().getItem(i);
                i1.putExtra("categoryid", clickedCategory.getId());
                i1.putExtra("enid",id);
                i1.putExtra("def",type);
                startActivity(i1);
            }
        });

    }
//    public void processResult(Category[] categories){
//        if(categories==null){
//            return;
//        }
//        c.clear();
//        for(Category cat:categories){
//            c.add(cat);
//        }
//        adapter.notifyDataSetChanged();
//    }

//    public void processResultid(String s){
//        if(s==null){
//            Toast.makeText(this,"no match found",Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(this,"match found",Toast.LENGTH_LONG).show();
//            id=s.toString();
//        }
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.item1){
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            Uri a = Uri.parse("http://www.zomato.com");
            i.setData(a);
            startActivity(i);
        }else if(item.getItemId()==R.id.item2){
            Intent i = new Intent (Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:phiz99@gmail.com"));
            i.putExtra(Intent.EXTRA_SUBJECT, "subject");
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }else{
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+ "7838668869"));
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }

        return true;
    }
}
