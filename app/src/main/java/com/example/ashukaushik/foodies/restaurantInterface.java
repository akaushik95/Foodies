package com.example.ashukaushik.foodies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashukaushik on 12/07/16.
 */
public interface restaurantInterface {
    @GET("search")
    //https://developers.zomato.com/api/v2.1/search?entity_id=289&entity_type=subzone
    Call<restaurantResponse> getRest(@Query("entity_id") String enid, @Query("entity_type") String enzone, @Query("apikey") String key);
}
