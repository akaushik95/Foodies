package com.example.ashukaushik.foodies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashukaushik on 13/07/16.
 */
public interface reviewInterface {
    @GET("reviews")
    Call<reviewResponse> getReviews(@Query("res_id") String resid, @Query("apikey") String key);
}
