package me.games.retrofitexample;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.games.retrofitexample.models.NearByLocationRespose;
import me.games.retrofitexample.models.NearbyPlace;
import me.games.retrofitexample.models.User;
import me.games.retrofitexample.models.UserSubmitResponse;
import me.games.retrofitexample.network.ApiService;
import me.games.retrofitexample.network.SampleApiClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

      ApiService api;

    private String pageToken;

    @Bind(R.id.etFirstName) EditText etFirstName;
    @Bind(R.id.etLastName) EditText etLastName;
    @Bind(R.id.etAddress) EditText etAddress;
    @Bind(R.id.etCountry) EditText etCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        api = SampleApiClient.getApi();




    }



    @OnClick(R.id.btnList)
    void showUsers(){
        getPlaces();
    }


void getPlaces(){
    api.getNearByLocations("27.7262241,85.3453077", "food", 500, "AIzaSyB486oAQ5KJexaDm79oYaw9wUFCm0UKq1g", pageToken, new Callback<NearByLocationRespose>() {
        @Override
        public void success(NearByLocationRespose nearByLocationRespose, Response response) {

            Log.e("Response", "Count:" + nearByLocationRespose.getNearbyPlaces().size());
            for (NearbyPlace place : nearByLocationRespose.getNearbyPlaces()){
                Log.e("nearby", "Place:" + place.getName());
            }


            pageToken = nearByLocationRespose.getNextPageToken();

        }

        @Override
        public void failure(RetrofitError error) {
            Log.e("Error", "error "+ error);
        }
    });
}




}
