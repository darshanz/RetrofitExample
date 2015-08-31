package me.games.retrofitexample.network;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by darshanz on 7/20/15.
 */
public class SampleApiClient {
    private  ApiService service;

    public static ApiService getApi(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setClient(new OkClient(new OkHttpClient()))
                .setEndpoint("https://maps.googleapis.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();


        return adapter.create(ApiService.class);
    }

}
