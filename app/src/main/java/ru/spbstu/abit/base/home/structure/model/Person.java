package ru.spbstu.abit.base.home.structure.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import ru.spbstu.abit.base.home.locations.model.Location;

public class Person {
    private String url;
    private String fullName;
    private ArrayList<Position> positions;
    private String email;
    private String phone;
    private Location location;
    private AcademicDegree degree;

    public Person (
            String url,
            String fullName,
            ArrayList< Position > positions,
            String email,
            String phone,
            Location location,
            AcademicDegree degree
    ) {
        this.url = url;
        this.fullName = fullName;
        this.positions = positions;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.degree = degree;
    }

    public String getUrl ( ) {
        return url == null ? "No URL" : url;
    }

    public void setUrl (@NonNull String url) {
        this.url = url;
    }

    public String getFullName ( ) {
        return fullName == null ? "No FullName" : fullName;
    }

    public void setFullName (@NonNull String fullName) {
        this.fullName = fullName;
    }

    public ArrayList< Position > getPositions ( ) {
        return positions == null ? new ArrayList< Position >() : positions;
    }

    public void setPositions (ArrayList< Position > positions) {
        this.positions = positions;
    }

    public String getEmail ( ) {
        return email == null ? "No Email" : email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPhone ( ) {
        return phone == null ? "No Phone" : phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public Location getLocation ( ) {
        return location == null ? new Location(null, 0.0, 0.0) : location;
    }

    public void setLocation (Location location) {
        this.location = location;
    }

    public AcademicDegree getDegree ( ) {
        return degree == null ? AcademicDegree.NO_DEGREE : degree;
    }

    public void setDegree (AcademicDegree degree) {
        this.degree = degree;
    }

    @NonNull
    @Override
    public String toString ( ) {
        return new StringBuilder( )
                .append("Person{")
                .append("url='").append(url != null ? url : "").append('\'')
                .append(", fullName='").append(fullName != null ? fullName : "").append('\'')
                .append(", positions=").append(positions != null ? positions : "")
                .append(", email='").append(email != null ? email : "").append('\'')
                .append(", phone='").append(phone != null ? phone : "").append('\'')
                .append(", location=").append(location != null ? location : "")
                .append(", degree=").append(url != null ? url : "")
                .append('}').toString( );
    }
}
