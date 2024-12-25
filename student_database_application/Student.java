package student_database_application;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static final int costOfCourse = 1000;
    private static int id = 100;

    // Constructor: Prompt user to enter student details
    public Student() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student's first name: ");
        this.firstName = sc.nextLine();

        System.out.print("Enter student's last name: ");
        this.lastName = sc.nextLine();

        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student's grade year: ");
        this.gradeYear = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        setStudentID();
    }

    // Generate Student ID
    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter course to enroll (Q to Quit): ");
            String course = sc.nextLine();

            if (course.equalsIgnoreCase("Q")) {
                break;
            }

            courses += course + ", ";
            tuitionBalance += costOfCourse;
        }

        // Remove trailing comma and space if courses are added
        if (!courses.isEmpty()) {
            courses = courses.substring(0, courses.length() - 2);
        }
    }

    // Pay tuition
    public void payTuition() {
        Scanner sc = new Scanner(System.in);
        viewBalance();

        while (true) {
            System.out.print("Enter your payment: Rs ");
            int payment = sc.nextInt();

            if (payment > tuitionBalance) {
                System.out.println("Your payment exceeds the balance. Please enter an amount up to Rs " + tuitionBalance);
            } else if (payment <= 0) {
                System.out.println("Invalid payment amount. Please enter a positive amount.");
            } else {
                tuitionBalance -= payment;
                System.out.println("Thank you for your payment of Rs " + payment);
                viewBalance();
                break;
            }
        }
    }

    // View balance
    public void viewBalance() {
        System.out.println("Current Tuition Balance: Rs " + tuitionBalance);
    }

    // Display student status
    @Override
    public String toString() {
        return "\nName: " + firstName + " " + lastName +
               "\nGrade Level: " + gradeYear +
               "\nStudent ID: " + studentID +
               "\nCourses Enrolled: " + (courses.isEmpty() ? "None" : courses) +
               "\nTuition Balance: Rs " + tuitionBalance;
    }
}
