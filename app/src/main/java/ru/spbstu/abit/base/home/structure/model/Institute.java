package ru.spbstu.abit.base.home.structure.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Institute {
    private String name;
    private ArrayList<StudyProgram> studyPrograms;
    private ArrayList<Department> departments;
    private ArrayList<Person> persons;
    private int colorId;
    private int colorLightId;
    private String url;

    public Institute (
            String name,
            ArrayList< StudyProgram > studyPrograms,
            ArrayList< Department > departments,
            ArrayList< Person > persons,
            int colorId,
            int colorLightId,
            String url
    ) {
        this.name = name;
        this.studyPrograms = studyPrograms;
        this.departments = departments;
        this.persons = persons;
        this.colorId = colorId;
        this.colorLightId = colorLightId;
        this.url = url;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public ArrayList< StudyProgram > getStudyPrograms ( ) {
        return studyPrograms;
    }

    public void setStudyPrograms (ArrayList< StudyProgram > studyPrograms) {
        this.studyPrograms = studyPrograms;
    }

    public ArrayList< Department > getDepartments ( ) {
        return departments;
    }

    public void setDepartments (ArrayList< Department > departments) {
        this.departments = departments;
    }

    public ArrayList< Person > getPersons ( ) {
        return persons;
    }

    public void setPersons (ArrayList< Person > persons) {
        this.persons = persons;
    }

    public int getColorId( ) {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getColorLightId() {
        return colorLightId;
    }

    public void setColorLightId(int colorLightId) {
        this.colorLightId = colorLightId;
    }

    public String getUrl ( ) {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    @NonNull
    @Override
    public String toString ( ) {
        return "Institute {\n" +
                "\tname = " + (name != null ? name : "") + '\n' +
                "\tstudyPrograms = " + (studyPrograms != null ? studyPrograms.toString() : "") + '\n' +
                "\tdepartments = " + (departments != null ? departments.toString() : "") + '\n' +
                "\tpersons = " + (persons != null ? persons.toString() : "") + '\n' +
                "\tcolorId = " + colorId + '\n' +
                "\tcolorLightId = " + colorLightId + '\n' +
                "\turl = '" + (url != null ? url : "") + '\'' + '\n' +
                '}';
    }
}
