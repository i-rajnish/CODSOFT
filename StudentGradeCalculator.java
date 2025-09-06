package CODSOFT;
import java.util.Scanner;

public class StudentGradeCalculator {
   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int totalMarks = 0;

    
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input! Marks must be between 0 and 100.");
                i--; 
                continue;
            }

            totalMarks += marks[i];
        }

        double average = (double) totalMarks / n;

        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n-- Result --");
        System.out.println("Total Marks: " + totalMarks + " / " + (n * 100));
        System.out.printf("Average Percentage: \n", average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}

