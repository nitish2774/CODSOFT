import java.util.Scanner;

public class GradeCalculator
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of subjects: ");
        int num_subjects = scanner.nextInt();
        int total_marks = 0;
        for (int i = 1; i <= num_subjects; i++) 
        {
            System.out.print("Mark of Subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            total_marks += marks;
        }
        double average_percentage = (double) total_marks / num_subjects;
        char grade;
        if (average_percentage >= 90) 
        {
            grade = 'A';
        }
         else if (average_percentage >= 80) 
        {
            grade = 'B';
        }
         else if (average_percentage >= 70) 
        {
            grade = 'C';
        
        } 
         else if (average_percentage >= 60) 
        {
            grade = 'D';
        }
         else 
        {
            grade = 'F';
        }
        System.out.println("\nResults:");
        System.out.println("Total_Marks: " + total_marks);
        System.out.println("Average_Percentage: " + average_percentage + "%");
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
