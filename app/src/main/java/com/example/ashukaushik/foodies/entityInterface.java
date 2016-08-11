package com.example.ashukaushik.foodies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashukaushik on 11/07/16.
 */
public interface entityInterface {
    @GET("locations")
    Call<entityResponse> getEntity(@Query("query") String query, @Query("apikey") String key);
}
