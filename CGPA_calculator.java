// Ahsan Idrees
// 2025-CYS-112

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CGPA_calculator
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to GPA Calculator...");
        System.out.println("Let's start...");
        System.out.print("Do you want to start program (Y/N): ");
        String start = sc.nextLine().trim().toUpperCase();

        if (!start.equals("Y"))
        {
            System.out.println("Oops you don't want to calculate your GPA...");
            sc.close();
            return;
        }

        Map<String, Double> grades = new HashMap<>();
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

        System.out.println("\nGrade scale:");
        for (Map.Entry<String, Double> entry : grades.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.print("\nHow many subjects did you study this semester: ");
        int subjects = Integer.parseInt(sc.nextLine().trim());

        double totalPoints = 0.0;
        double totalCreditHours = 0.0;

        for (int i = 1; i <= subjects; i++)
        {
            System.out.print("\nSubject " + i + " name: ");
            String name = sc.nextLine().trim();

            int creditHours = readCreditHours(sc, name);
            double gradePoint = readGrade(sc, grades, name);

            totalPoints += gradePoint * creditHours;
            totalCreditHours += creditHours;
        }

        double gpa = totalPoints / totalCreditHours;
        System.out.printf("%nYour GPA is: %.2f%n", gpa);
        System.out.println("Congratulations...");

        sc.close();
    }

    private static int readCreditHours(Scanner sc, String subjectName)
    {
        while (true)
        {
            System.out.print("Credit hours for " + subjectName + ": ");
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0)
                {
                    return value;
                }
                System.out.println("Credit hours must be a positive number.");
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static double readGrade(Scanner sc, Map<String, Double> grades, String subjectName) {
        while (true)
        {
            System.out.print("Grade for " + subjectName + ": ");
            String grade = sc.nextLine().trim().toUpperCase();
            if (grades.containsKey(grade))
            {
                return grades.get(grade);
            }
            System.out.println("Invalid grade. Please enter one of: " + grades.keySet());
        }
    }
}