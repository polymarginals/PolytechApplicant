package ru.spbstu.abit.base.home.structure.model;

import android.support.annotation.NonNull;

public class Position {
    private String positionName;
    private Department department;
    private Institute institute;

    public Position (
            String positionName,
            Department department,
            Institute institute
    ) {
        this.positionName = positionName;
        this.department = department;
        this.institute = institute;
    }

    public String getPositionName ( ) {
        return positionName;
    }

    public void setPositionName (String positionName) {
        this.positionName = positionName;
    }

    public Department getDepartment ( ) {
        return department;
    }

    public void setDepartment (Department department) {
        this.department = department;
    }

    public Institute getInstitute ( ) {
        return institute;
    }

    public void setInstitute (Institute institute) {
        this.institute = institute;
    }

    @NonNull
    @Override
    public String toString ( ) {
        return "Position {\n" +
                "\tpositionName = '" + (positionName != null ? positionName : "") + '\'' + '\n' +
                "\tdepartment = " + (department != null ? department : "") + '\n' +
                "\tinstitute = " + (institute != null ? institute : "") + '\n' +
                '}';
    }
}
