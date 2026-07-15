// Ahsan Idrees
// 2025-CYS-112

import java.util.HashMap;
import java.util.Scanner;

public class CGPA_calculator
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to GPA Calculator...");
        System.out.println("Let's start...");
        System.out.print("Do you want to start program (Y/N): ");
        String start = sc.nextLine().toUpperCase();

        if (!start.equals("Y"))
        {
            System.out.println("Oops! You don't want to calculate your GPA.");
            return;
        }

        HashMap<String, Double> grades = new HashMap<>();

        grades.put("A+", 4.0);
        grades.put("A", 4.0);
        grades.put("A-", 3.7);
        grades.put("B+", 3.3);
        grades.put("B", 3.0);
        grades.put("B-", 2.7);
        grades.put("C+", 2.3);
        grades.put("C", 2.0);
        grades.put("C-", 1.7);
        grades.put("D+", 1.3);
        grades.put("D", 1.0);
        grades.put("F", 0.0);

        System.out.println("\nGrade Scale:");
        System.out.println("A+ : 4.0");
        System.out.println("A  : 4.0");
        System.out.println("A- : 3.7");
        System.out.println("B+ : 3.3");
        System.out.println("B  : 3.0");
        System.out.println("B- : 2.7");
        System.out.println("C+ : 2.3");
        System.out.println("C  : 2.0");
        System.out.println("C- : 1.7");
        System.out.println("D+ : 1.3");
        System.out.println("D  : 1.0");
        System.out.println("F  : 0.0");

        System.out.print("\nHow many subjects did you study this semester: ");
        int subjects = sc.nextInt();
        sc.nextLine();

        double totalPoints = 0;
        int totalCreditHours = 0;

        for (int i = 1; i <= subjects; i++)
        {
            System.out.print("\nEnter Subject Name: ");
            String subject = sc.nextLine();

            System.out.print("Enter Credit Hours: ");
            int creditHours = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Grade: ");
            String grade = sc.nextLine().toUpperCase();

            while (!grades.containsKey(grade))
            {
                System.out.println("Invalid Grade! Enter Again.");
                System.out.print("Enter Grade: ");
                grade = sc.nextLine().toUpperCase();
            }

            totalPoints = totalPoints + (grades.get(grade) * creditHours);
            totalCreditHours = totalCreditHours + creditHours;
        }

        double gpa = totalPoints / totalCreditHours;

        System.out.printf("\nYour GPA is: %.2f\n", gpa);
        System.out.println("Congratulations!");

        sc.close();
    }
}
