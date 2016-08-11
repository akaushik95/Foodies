package com.example.ashukaushik.foodies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashukaushik on 11/07/16.
 */
public interface categoryInterface {
    @GET("categories")
    Call<CategoriesResponse> getCategory(@Query("apikey") String s);
}
