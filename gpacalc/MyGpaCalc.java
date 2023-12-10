package gpacalc;

import java.util.ArrayList;
import java.util.Scanner;

public class MyGpaCalc {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
                
        // First Interface
            System.out.println("Hello student!! Welcome to My GPA Grading Calculator\n");

        // Prompt the use to enter the number of Courses to calculate
            System.out.print("Enter the number of Courses: ");
            int numberOfCourseInfos = scanner.nextInt();

        // ArrayList to store CourseInfo objects
            ArrayList<CourseInfo> CourseInfos = new ArrayList<>();

        // Input CourseInfo details
            for (int i = 0; i < numberOfCourseInfos; i++) {
                System.out.println("\nEnter details of the Courses " + (i + 1) + ":");
                scanner.nextLine(); // Continue newline

                System.out.print("Course Name: ");
                String name = scanner.nextLine();

                System.out.print("Course Code: ");
                String code = scanner.nextLine();

                System.out.print("Course Unit: ");
                int unit = scanner.nextInt();

                System.out.print("Course Score: ");
                int score = scanner.nextInt();

                // Create CourseInfo object and add to ArrayList
                CourseInfo CourseInfo = new CourseInfo(name, code, unit, score);
                CourseInfos.add(CourseInfo);
            }

        // Calculate total grade points and total units
        int totalGradePoints = 0;
        int totalUnits = 0;

        for (CourseInfo CourseInfo : CourseInfos) {
            totalGradePoints += CourseInfo.getGradePoint() * CourseInfo.getUnit();
            totalUnits += CourseInfo.getUnit();
        }

    // Calculate GPA to 2 decimal places
        double gpa = (double) totalGradePoints / totalUnits;

    // Display the result in a tabular form
        System.out.println("\nResult:");
        printTableLine();
        System.out.printf("| %-50s | %-14s | %-14s | %-14s |\n", "Course Name & Code", "Course Unit", "Grade", "Grade-Unit");
        printTableLine();

        for (CourseInfo CourseInfo : CourseInfos) {
            System.out.printf("| %-50s | %-14d | %-14s | %-14d |\n", CourseInfo.getName() + " " + CourseInfo.getCode(), CourseInfo.getUnit(),CourseInfo.getGrade(), CourseInfo.getGradePoint());
        }

        printTableLine();
        System.out.println();

        // Print GPA
        System.out.printf("Your GPA is = %.2f\n", gpa);

        // Close the scanner
        scanner.close();
    }

    // Help method to print horizontal lines for the table
    private static void printTableLine() {
        System.out.println("+--------------------------------------------------+----------------+----------------+----------------+");
    }
}
