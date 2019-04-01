package ru.spbstu.abit.base.home.timeline.model;

import android.support.annotation.NonNull;

public class TimelineEvent {
    private String educationForm;
    private String fundingForm;
    private String description;
    private String month;
    private int day;
    private boolean selected;

    public TimelineEvent (
            String educationForm,
            String fundingForm,
            String description,
            String month,
            int day,
            boolean selected
    ) {
        this.educationForm = educationForm;
        this.fundingForm = fundingForm;
        this.description = description;
        this.month = month;
        this.day = day;
        this.selected = selected;
    }

    public String getEducationForm ( ) {
        return educationForm;
    }

    public void setEducationForm (String educationForm) {
        this.educationForm = educationForm;
    }

    public String getFundingForm ( ) {
        return fundingForm;
    }

    public void setFundingForm (String fundingForm) {
        this.fundingForm = fundingForm;
    }

    public String getDescription ( ) {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getMonth ( ) {
        return month;
    }

    public void setMonth (String month) {
        this.month = month;
    }

    public int getDay ( ) {
        return day;
    }

    public void setDay (int day) {
        this.day = day;
    }

    public boolean isSelected ( ) {
        return selected;
    }

    public void setSelected (boolean selected) {
        this.selected = selected;
    }

    @NonNull
    @Override
    public String toString ( ) {
        return "TimelineEvent{" +
                "educationForm='" + educationForm + '\'' +
                ", fundingForm='" + fundingForm + '\'' +
                ", description='" + description + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", selected='" + selected + '\'' +
                '}';
    }
}
