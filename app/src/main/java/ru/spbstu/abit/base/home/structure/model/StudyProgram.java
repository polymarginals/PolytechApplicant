package ru.spbstu.abit.base.home.structure.model;

import android.support.annotation.NonNull;

public class StudyProgram {
    private String code;
    private String fieldOfStudy;
    private String name;
    private int priceBaseRur;
    private int priceOthersRur;

    public StudyProgram (
            String code,
            String fieldOfStudy,
            String name,
            int priceBaseRur,
            int priceOthersRur
    ) {
        this.code = code;
        this.fieldOfStudy = fieldOfStudy;
        this.name = name;
        this.priceBaseRur = priceBaseRur;
        this.priceOthersRur = priceOthersRur;
    }

    public String getCode ( ) {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public String getFieldOfStudy ( ) {
        return fieldOfStudy;
    }

    public void setFieldOfStudy (String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getPriceBaseRur ( ) {
        return priceBaseRur;
    }

    public void setPriceBaseRur (int priceBaseRur) {
        this.priceBaseRur = priceBaseRur;
    }

    public int getPriceOthersRur ( ) {
        return priceOthersRur;
    }

    public void setPriceOthersRur (int priceOthersRur) {
        this.priceOthersRur = priceOthersRur;
    }

    @NonNull
    @Override
    public String toString ( ) {
        return "StudyProgram {\n" +
                "\tcode = " + (code != null ? code : "") + '\n' +
                "\tfieldOfStudy = '" + (fieldOfStudy != null ? fieldOfStudy : "") + '\'' + '\n' +
                "\tname = '" + (name != null ? name : "") + '\'' + '\n' +
                "\tpriceBaseRur = " + priceBaseRur + '\n' +
                "\tpriceOthersRur = " + priceOthersRur + '\n' +
                '}';
    }
}
