package com.example.studentreportcardv2;

public class schoolClasses {
    String classGrade;
    String className;

    public schoolClasses(int list_row, String classGrade, String className) {
        this.classGrade = classGrade;
        this.className = className;
    }

    public schoolClasses(int list_row, String rekenen) {
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
