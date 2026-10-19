
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class studentgradetracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter marks (0-100): ");
                double marks = sc.nextDouble();
                sc.nextLine();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks! Enter 0 to 100.");
                } else {
                    students.add(new Student(name, marks));
                    System.out.println("Student added successfully!");
                }
            }

            else if (choice == 2) {

                if (students.isEmpty()) {
                    System.out.println("No student records found.");
                } else {
                    double total = 0;
                    double highest = students.get(0).marks;
                    double lowest = students.get(0).marks;

                    System.out.println("\n===== STUDENT REPORT =====");
                    System.out.printf("%-20s %s%n", "Student Name", "Marks");
                    System.out.println("------------------------------");

                    for (Student s : students) {
                        System.out.printf("%-20s %.2f%n",
                                s.name, s.marks);

                        total += s.marks;

                        if (s.marks > highest) {
                            highest = s.marks;
                        }

                        if (s.marks < lowest) {
                            lowest = s.marks;
                        }
                    }

                    double average = total / students.size();

                    System.out.println("------------------------------");
                    System.out.printf("Total Students: %d%n",
                            students.size());
                    System.out.printf("Average Marks: %.2f%n", average);
                    System.out.printf("Highest Marks: %.2f%n", highest);
                    System.out.printf("Lowest Marks: %.2f%n", lowest);
                }
            }

            else if (choice == 3) {
                System.out.println("Thank you for using Student Grade Tracker!");
                break;
            }

            else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
