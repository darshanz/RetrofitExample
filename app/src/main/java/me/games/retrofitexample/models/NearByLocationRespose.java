package me.games.retrofitexample.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by darshanz on 8/30/15.
 */
public class NearByLocationRespose {



   @SerializedName("results")
  ArrayList<NearbyPlace> nearbyPlaces;

    @SerializedName("next_page_token")
    private String nextPageToken;


    public ArrayList<NearbyPlace> getNearbyPlaces() {
        return nearbyPlaces;
    }

    public void setNearbyPlaces(ArrayList<NearbyPlace> nearbyPlaces) {
        this.nearbyPlaces = nearbyPlaces;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }
}
