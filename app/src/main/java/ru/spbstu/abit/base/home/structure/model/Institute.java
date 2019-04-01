package ru.spbstu.abit.base.home.structure.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Institute {
    private String name;
    private ArrayList<StudyProgram> studyPrograms;
    private ArrayList<Department> departments;
    private ArrayList<Person> persons;
    private int backgroundId;
    private String url;

    public Institute (
            String name,
            ArrayList< StudyProgram > studyPrograms,
            ArrayList< Department > departments,
            ArrayList< Person > persons,
            int backgroundId,
            String url
    ) {
        this.name = name;
        this.studyPrograms = studyPrograms;
        this.departments = departments;
        this.persons = persons;
        this.backgroundId = backgroundId;
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

    public int getBackgroundId ( ) {
        return backgroundId;
    }

    public void setBackgroundId (int backgroundId) {
        this.backgroundId = backgroundId;
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
        return new StringBuilder( )
                .append("Institute{")
                .append("name=").append(name != null ? name : "")
                .append(", studyPrograms=").append(studyPrograms != null ? studyPrograms.toString( ) : "")
                .append(", departments=").append(departments != null ? departments.toString( ) : "")
                .append(", persons=").append(persons != null ? persons.toString() : "")
                .append(", backgroundId=").append(backgroundId)
                .append(", url='").append(url != null ? url : "").append('\'')
                .append('}').toString( );
    }
}
