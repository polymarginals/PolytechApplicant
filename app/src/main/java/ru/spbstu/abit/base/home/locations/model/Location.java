package ru.spbstu.abit.base.home.locations.model;

import android.support.annotation.NonNull;

public class Location {
    private String addressName;
    private double longitude;
    private double latitude;

    public Location (
            String addressName,
            double longitude,
            double latitude
    ) {
        this.addressName = addressName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getAddressName ( ) {
        return addressName;
    }

    public void setAddressName (String addressName) {
        this.addressName = addressName;
    }

    public double getLongitude ( ) {
        return longitude;
    }

    public void setLongitude (double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude ( ) {
        return latitude;
    }

    public void setLatitude (double latitude) {
        this.latitude = latitude;
    }

    @NonNull
    @Override
    public String toString ( ) {
        return new StringBuilder( )
                .append("Location{")
                .append("addressName='").append(addressName != null ? addressName : "").append('\'')
                .append(", longitude=").append(longitude)
                .append(", latitude=").append(latitude)
                .append('}').toString( );
    }
}
