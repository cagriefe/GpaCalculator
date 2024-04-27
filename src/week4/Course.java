package week4;

public class Course {
    private String name;
    private String grade;
    private int credit;

    public Course() {
        this.name = "";
        this.grade = "";
        this.credit = 0;
    }

    public Course(String name, String grade, int credit) {
        this.name = name;
        this.grade = grade;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public int getCredit() {
        return credit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    
    public double calculateGrade() {
        if (grade.equals("A")) {
            return 4.0;
        } else if (grade.equals("B")) {
            return 3.0;
        } else if (grade.equals("C")) {
            return 2.0;
        } else if (grade.equals("D")) {
            return 1.0;
        } else if (grade.equals("F")) {
            return 0.0;
        } else {
            return 0.0;
        }
    }

    public String toString() {
        return "Course [name=" + name + ", grade=" + grade + ", credit=" + credit + "]";
    }
}
