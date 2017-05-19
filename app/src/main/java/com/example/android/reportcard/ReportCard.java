package com.example.android.reportcard;

import java.util.Arrays;

public class ReportCard {

    private String firstName;     //here we store the first name of the student,
    private String lastName;      //the last name of the student,
    private String teacherName;   //the name of the teacher,
    private byte[] classGrades;    //the grades,
    private double average;       //and the average...
    private String gradeInText;   //this will show a short text depending on the percentage the student achieved
    private final byte max_percent = 100;   //this is the maximum percentage the student can get
    private final byte min_to_succeed = 60; //this is the minimum percentage the student can get to succeed
    private final byte min_percent = 0;     //this is the minimum percentage the student can get

//here comes the constructor

    public ReportCard(String firstName, String lastName, String teacherName, double average, byte[] classGrades, String gradeInText) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherName = teacherName;
        this.average = average;
        this.classGrades = classGrades;
        this.gradeInText = gradeInText;
    }

//here comes all the setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setClassGrades(byte[] classGrades) {
        this.classGrades = classGrades;
    }

    public void setAverage(double average) {
        this.average = calculateAverage();
    }

    public void setGradeInText(String gradeInText) {
        this.gradeInText = gradeInText;
    }
    //here comes all the getters


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public byte[] getClassGrades() {
        return classGrades;
    }

    public double getAverage() {
        return average;
    }

    public String getGradeInText() {
        return gradeInText;
    }

    public double calculateAverage(){
        int sum = 0;
        for (int i = 0; i < classGrades.length; i++){
            sum += classGrades[i];
        }
        withText();
        return (sum / classGrades.length);
    }

    public void withText(){

        if (calculateAverage() < min_to_succeed && calculateAverage() >= min_percent){
            gradeInText = "Failed!";
        }
        else if (calculateAverage() == max_percent){
            gradeInText = "Excellent work!";
        }
        else if (calculateAverage() < min_percent || calculateAverage() > max_percent){
            gradeInText = "Calculation error!";
        }
        else{
            gradeInText = "Success!";
        }
    }

    @Override
    public String toString() {
        return "Student name: " + getFirstName() + getLastName() + "\n" +
                "Teacher name: " + getTeacherName() + "\n" +
                "Grades: " + Arrays.toString(classGrades) + "\n" +
                "Average: " + getAverage() + "\n" +
                gradeInText;
    }
}