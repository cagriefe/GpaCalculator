package week4;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Student Information");
        frame.setSize(750, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use absolute positioning

        // Labels
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 30);
        frame.add(nameLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 60, 100, 30);
        frame.add(idLabel);

        JLabel gpaLabel = new JLabel("GPA:");
        gpaLabel.setBounds(20, 100, 100, 30);
        frame.add(gpaLabel);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(20, 140, 100, 30);
        frame.add(departmentLabel);

        // Text fields
        JTextField nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 30);
        frame.add(nameField);

        JTextField idField = new JTextField();
        idField.setBounds(120, 60, 200, 30);
        frame.add(idField);

        JTextField gpaField = new JTextField();
        gpaField.setBounds(120, 100, 200, 30);
        frame.add(gpaField);

        JTextField departmentField = new JTextField();
        departmentField.setBounds(120, 140, 200, 30);
        frame.add(departmentField);

        // Button
        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.setBounds(120, 380, 150, 30);
        frame.add(addCourseButton);

        // Course details
        JLabel courseLabel = new JLabel("Course Details:");
        courseLabel.setBounds(20, 220, 100, 30);
        frame.add(courseLabel);

        JLabel courseNameLabel = new JLabel("Course Name:");
        courseNameLabel.setBounds(20, 260, 100, 30);
        frame.add(courseNameLabel);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(20, 300, 100, 30);
        frame.add(gradeLabel);

        JLabel creditLabel = new JLabel("Credit:");
        creditLabel.setBounds(20, 340, 100, 30);
        frame.add(creditLabel);

        JTextField courseNameField = new JTextField();
        courseNameField.setBounds(120, 260, 200, 30);
        frame.add(courseNameField);

        JTextField gradeField = new JTextField();
        gradeField.setBounds(120, 300, 200, 30);
        frame.add(gradeField);

        JTextField creditField = new JTextField();
        creditField.setBounds(120, 340, 200, 30);
        frame.add(creditField);

        // Button
        JButton calculateButton = new JButton("Calculate GPA");
        calculateButton.setBounds(375, 380, 150, 30);
        frame.add(calculateButton);

        // Result label
        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(20, 420, 300, 30);
        frame.add(resultLabel);

        // Course list
        DefaultListModel<String> courseListModel = new DefaultListModel<>();
        JList<String> courseList = new JList<>(courseListModel);
        JScrollPane courseScrollPane = new JScrollPane(courseList);
        courseScrollPane.setBounds(350, 20, 200, 300);
        frame.add(courseScrollPane);

        // Action listener for "Add Course" button
        addCourseButton.addActionListener(e -> {
            // Get course details from text fields
            String courseName = courseNameField.getText();
            String grade = gradeField.getText();
            int credit = Integer.parseInt(creditField.getText());

            // Add course details to the list
            String courseDetails = courseName + " - Grade: " + grade + ", Credit: " + credit;
            courseListModel.addElement(courseDetails);

            // Clear course fields
            courseNameField.setText("");
            gradeField.setText("");
            creditField.setText("");
        });

        // Action listener for "Calculate GPA" button
        calculateButton.addActionListener(e -> {
            // Parse student information
            String name = nameField.getText();
            int id = Integer.parseInt(idField.getText());
            double gpa = Double.parseDouble(gpaField.getText());
            String department = departmentField.getText();

            // Create Student object
            Student student = new Student();
            student.setName(name);
            student.setID(id);
            student.setGPA(gpa);
            student.setDepartment(department);

            // Add courses to student
            for (int i = 0; i < courseListModel.size(); i++) {
                String courseDetails = courseListModel.getElementAt(i);
                String[] parts = courseDetails.split(" - Grade: ");
                String courseName = parts[0];
                parts = parts[1].split(", Credit: ");
                String grade = parts[0];
                int credit = Integer.parseInt(parts[1]);
                Course course = new Course(courseName, grade, credit);
                student.addCourse(course);
            }

            // Calculate GPA and display result
            double calculatedGPA = student.calculateGPA();
            resultLabel.setText("Calculated GPA: " + calculatedGPA);
        });

        // Make frame visible
        frame.setVisible(true);
    }
}
