package me.games.retrofitexample.network;


import java.util.ArrayList;
import java.util.Map;

import me.games.retrofitexample.models.NearByLocationRespose;
import me.games.retrofitexample.models.NearbyPlace;
import me.games.retrofitexample.models.User;
import me.games.retrofitexample.models.UserSubmitResponse;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by darshanz on 7/20/15.
 */
public interface ApiService {



    @GET("/maps/api/place/nearbysearch/json")
    void getNearByLocations(@Query("location") String location,
                            @Query("types") String types,
                            @Query("radius") int radius,
                            @Query("key") String key,
                            @Query("pagetoken") String pageToken,
                            Callback<NearByLocationRespose> response);

}
