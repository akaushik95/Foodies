package com.example.ashukaushik.foodies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashukaushik on 07/07/16.
 */
public class categoryAdapter extends ArrayAdapter<CategoriesResponse.Category> {
    Context context;
    ArrayList<CategoriesResponse.Category> mData;
    public categoryAdapter(Context context, ArrayList<CategoriesResponse.Category> objects) {
        super(context,0, objects);
        mData=objects;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null){
            v= LayoutInflater.from(context).inflate(R.layout.categoryadapterlayout,parent,false);
        }
        TextView name=(TextView)v.findViewById(R.id.nameadapter);
        //TextView id=(TextView)v.findViewById(R.id.idadapter);
        name.setText(getItem(position).getName());
        //id.setText(getItem(position).getId()+"");

        return v;
    }
}
