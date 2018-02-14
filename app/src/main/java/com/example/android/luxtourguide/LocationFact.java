package com.example.android.luxtourguide;

/**
 * Created by neo on 31/12/2017.
 */

public class LocationFact {
    private String mLocationTitle;
    private String mLocationDescription;
    private int mLocationImageId = -1;
    private int mLocationSound = -1;

    // here we have two constructors
    // one takes 2 arguments when the image is not needed
    // the second takes 3 arguments, including the image id
    // constructor overloading!!
    public LocationFact(String title, String description) {
        mLocationTitle = description;
        mLocationDescription = title;
    }

    public LocationFact(String title, String description, int drawableId) {
        mLocationTitle = description;
        mLocationDescription = title;
        mLocationImageId = drawableId;
    }

    public LocationFact(String title, String description, int drawableId, int soundId) {
        mLocationTitle = description;
        mLocationDescription = title;
        mLocationImageId = drawableId;
        mLocationSound = soundId;
    }

    public String getLocationDescription() {
        return mLocationDescription;
    }

    public String getLocationTitle() {
        return mLocationTitle;
    }

    public int getLocationImage() { return mLocationImageId; }

    public boolean hasImage() { return mLocationImageId != -1; }

    public boolean hasSound() { return mLocationSound != -1; }

    public int getAudioResourceId() { return mLocationSound; }

    @Override
    public String toString() {
        return "LocationFact{" +
                "mLocationTitle='" + mLocationTitle + '\'' +
                ", mLocationDescription='" + mLocationDescription + '\'' +
                ", mLocationImageId=" + mLocationImageId +
                ", mLocationSound=" + mLocationSound +
                '}';
    }
}
