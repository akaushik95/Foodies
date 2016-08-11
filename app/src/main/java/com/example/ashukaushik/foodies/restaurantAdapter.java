package com.example.ashukaushik.foodies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ashukaushik on 08/07/16.
 */
public class restaurantAdapter extends ArrayAdapter<restaurantResponse.restaurant> {
    Context context;
    ArrayList<restaurantResponse.restaurant> mdata;
    public restaurantAdapter(Context context, ArrayList<restaurantResponse.restaurant> objects) {
        super(context, 0, objects);
        mdata=objects;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null){
            v= LayoutInflater.from(context).inflate(R.layout.restaurantadapterlayout,parent,false);
        }
        TextView name=(TextView)v.findViewById(R.id.namerestaurantadapter);
        ImageView image =(ImageView)v.findViewById(R.id.imagerestaurantadapter);
        name.setText("Res ID:"+getItem(position).getResId()+"\n"+"Name:"+getItem(position).getName()+"\n"+ "Address:"+getItem(position).getLocation().getAddress()+"\n"+ "Cuisines:"+getItem(position).getCuisines()+"\n"+ "Cost for two: Rs."+getItem(position).getAverageCostForTwo());
//        if(getItem(position).getImage()!=null){
//            Picasso.with(context).load(getItem(position).getImage()).into(image);
//        }else{
//            Picasso.with(context).load("http://www.manglampower.com/images/no-image-available(2).jpg").into(image);
//        }

        return v;
    }
}
