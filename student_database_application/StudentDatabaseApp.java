package student_database_application;

import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Ask how many students to enroll
        System.out.print("Enter number of new students to enroll: ");
        int numOfStudents = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Step 2: Create an array to store student objects
        Student[] students = new Student[numOfStudents];

        // Step 3: Process each student individually
        for (int i = 0; i < numOfStudents; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            students[i] = new Student(); // Initialize Student object
            students[i].enroll();        // Enroll in courses
            students[i].payTuition();    // Pay tuition fees
        }

        // Step 4: Display all student details
        System.out.println("\n--- All Student Details ---");
        for (int i = 0; i < numOfStudents; i++) {
            System.out.println(students[i].toString());
        }

        sc.close(); // Close Scanner
    }
}
