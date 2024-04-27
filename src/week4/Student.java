package week4;

import java.util.ArrayList;

public class Student {
    private String name;
    private int ID;
    private double GPA;
    private String department;
    public ArrayList<Course> courseList;

    public Student() {
        this.name = "";
        this.ID = 0;
        this.GPA = 0.0;
        this.department = "";
        this.courseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public double getGPA() {
        return GPA;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public double calculateGPA() {
        if (courseList.isEmpty()) {
            return 0.0;
        }

        double totalGradePoints = 0.0;
        int totalCredits = 0;

        for (Course course : courseList) {
            totalGradePoints += course.calculateGrade() * course.getCredit();
            totalCredits += course.getCredit();
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return totalGradePoints / totalCredits;
    }


    
    public String toString() {
        return "Student [name=" + name + ", ID=" + ID + ", GPA=" + GPA + ", department=" + department + "]";
    }
}
