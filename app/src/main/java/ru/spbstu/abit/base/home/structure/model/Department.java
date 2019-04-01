package ru.spbstu.abit.base.home.structure.model;

import android.support.annotation.NonNull;

public class Department {
    private String name;
    private String url;

    public Department (
            String name,
            String url
    ) {
        this.name = name;
        this.url = url;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (@NonNull String name) {
        this.name = name;
    }

    public String getUrl ( ) {
        return url;
    }

    public void setUrl (@NonNull String url) {
        this.url = url;
    }

    @NonNull
    @Override
    public String toString ( ) {
        return new StringBuilder( )
                .append("Department{")
                .append("name='").append(name != null ? name : "").append('\'')
                .append(", url='").append(url != null ? url : "").append('\'')
                .append('}').toString();
    }
}