package com.example.ashukaushik.foodies;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class reviewActivity extends AppCompatActivity {
    TextView reviewtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        reviewtv = (TextView) findViewById(R.id.reviewTextView);
        String s = getIntent().getStringExtra("resid");
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://developers.zomato.com/api/v2.1/").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();
        final reviewInterface reviewinterface=retrofit.create(reviewInterface.class);
        Call<reviewResponse> call = reviewinterface.getReviews(s,"39c74c0e0815c8fedc0eb526081a2d40");
        call.enqueue(new Callback<reviewResponse>() {
            @Override
            public void onResponse(Call<reviewResponse> call, Response<reviewResponse> response) {
                reviewResponse obj=response.body();
                if (obj.getUserreviews().size() == 0) {
                    reviewtv.setText("No reviews yet");
                    return;
                } else {
                    for (int i = 0; i < obj.getUserreviews().size(); i++) {
                        reviewtv.setText(reviewtv.getText() + "\n" + "Rating :" + obj.getUserreviews().get(i).getReview().getRating()+ "\n" + "Review :" + obj.getUserreviews().get(i).getReview().getReviewText() + "\n");
                    }
                }
            }

            @Override
            public void onFailure(Call<reviewResponse> call, Throwable t) {

            }
        });
//        reviewDownloadTask rdtk=new reviewDownloadTask(this);
//        rdtk.execute("https://developers.zomato.com/api/v2.1/reviews?res_id="+s+"&apikey=39c74c0e0815c8fedc0eb526081a2d40&count=20");
    }

//    public void processResultReview(final reviews[] reviews) {
//        if (reviews == null) {
//            reviewtv.setText("No reviews yet");
//            return;
//        } else {
//            for (int i = 0; i < reviews.length; i++) {
//
//                reviewtv.setText(reviewtv.getText() + "\n" + "Rating :" + reviews[i].getRating() + "\n" + "Review :" + reviews[i].getReviewText() + "\n");
//
//            }
//
//        }
//    }
}