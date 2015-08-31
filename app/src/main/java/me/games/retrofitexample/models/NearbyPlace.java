package me.games.retrofitexample.models;

/**
 * Created by darshanz on 8/30/15.
 */
public class NearbyPlace {

    private String icon;
    private String name;
    private Geometry geometry;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
