package me.games.retrofitexample.network;


import java.util.ArrayList;
import java.util.Map;

import me.games.retrofitexample.models.User;
import me.games.retrofitexample.models.UserSubmitResponse;
import retrofit.Callback;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by darshanz on 7/20/15.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("/users")
    void submitUser(@FieldMap Map<String, String> fields, Callback<UserSubmitResponse> callback);


    @GET("/users")
    void getUserList(Callback<ArrayList<User>> response);
}
