package com.example.ashukaushik.foodies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashukaushik on 12/07/16.
 */
public interface categoryRestaurantInterface {
    @GET("search")
    Call<restaurantResponse> getcatRest(@Query("entity_id") String enid, @Query("entity_type") String enty, @Query("category") int cat, @Query("apikey") String key) ;

}
