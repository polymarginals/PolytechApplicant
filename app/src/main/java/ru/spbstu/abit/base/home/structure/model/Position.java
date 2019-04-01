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
        return positionName == null ? "No Position Name" : positionName;
    }

    public void setPositionName (String positionName) {
        this.positionName = positionName;
    }

    public Department getDepartment ( ) {
        return department == null ? new Department(null, null) : department;
    }

    public void setDepartment (Department department) {
        this.department = department;
    }

    public Institute getInstitute ( ) {
        return institute == null ? new Institute(null, null, null, null, 0, null) : institute;
    }

    public void setInstitute (Institute institute) {
        this.institute = institute;
    }

    @NonNull
    @Override
    public String toString ( ) {
        return new StringBuilder( )
                .append("Position{")
                .append("positionName='").append(positionName != null ? positionName : "").append('\'')
                .append(", department=").append(department != null ? department : "")
                .append(", institute=").append(institute != null ? institute : "")
                .append('}').toString( );
    }
}
