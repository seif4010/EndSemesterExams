package com.example.endsemesterexams;

public class Exams {
    private String FirstName1, LastName1, Schools;
    private String IDNo;
    private String SchoolCode;
    String name;

    public Exams(String FirstName1, String LastName1, String IDNo, String Schools, String SchoolCode) {
        this.FirstName1 = FirstName1;
        this.LastName1 = LastName1;
        this.IDNo = IDNo;
        this.Schools = Schools;
        this.SchoolCode = SchoolCode;
    }

public String getName() {
    return name;
    }

    //getter and setter methods

    public String getSchools() {
        return Schools;
    }

    public void setSchools(String schools) {
        Schools = schools;
    }

    public String getSchoolCode() {
        return SchoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        SchoolCode = schoolCode;
    }

    public String getFirstName() {
        return FirstName1;
    }

    public void setFirstName(String firstName1) {
        FirstName1 = firstName1;
    }

    public String getLastName() {
        return LastName1;
    }

    public void setLastName(String lastName1) {
        LastName1 = lastName1;
    }

    public String getIDNo() {
        return IDNo;
    }

    public void setIDNo(String IDNo) {
        this.IDNo = IDNo;
    }
}