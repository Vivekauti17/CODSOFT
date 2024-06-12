// Student Course Registration System
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CourseRegistrationSystem {
    
    // Class to store course information
    static class Course {
        String code;
        String title;
        String description;
        int capacity;
        String schedule;
        int enrolled;

        Course(String code, String title, String description, int capacity, String schedule) {
            this.code = code;
            this.title = title;
            this.description = description;
            this.capacity = capacity;
            this.schedule = schedule;
            this.enrolled = 0;
        }

        boolean isAvailable() {
            return enrolled < capacity;
        }
    }

    // Class to store student information
    static class Student {
        String id;
        String name;
        List<String> registeredCourses;

        Student(String id, String name) {
            this.id = id;
            this.name = name;
            this.registeredCourses = new ArrayList<>();
        }
    }

    // Databases
    static Map<String, Course> courseDatabase = new HashMap<>();
    static Map<String, Student> studentDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample courses
        courseDatabase.put("CS101", new Course("CS101", "Introduction to Computer Science", "Basics of computer science", 2, "Mon 10-12"));
        courseDatabase.put("MATH101", new Course("MATH101", "Calculus I", "Differential and integral calculus", 2, "Tue 9-11"));
        courseDatabase.put("PHY101", new Course("PHY101", "Physics I", "Fundamentals of physics", 2, "Wed 1-3"));

        // Sample students
        studentDatabase.put("S1001", new Student("S1001", "John Doe"));
        studentDatabase.put("S1002", new Student("S1002", "Jane Smith"));

        boolean running = true;

        while (running) {
            System.out.println("\nCourse Registration System");
            System.out.println("1. List courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    registerCourse(studentId, scanner);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    dropCourse(studentId, scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to list all available courses
    static void listCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courseDatabase.values()) {
            System.out.println(course.code + ": " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Schedule: " + course.schedule);
            System.out.println("Capacity: " + course.capacity);
            System.out.println("Enrolled: " + course.enrolled);
            System.out.println("Available slots: " + (course.capacity - course.enrolled));
            System.out.println();
        }
    }

    // Method for student registration for a course
    static void registerCourse(String studentId, Scanner scanner) {
        Student student = studentDatabase.get(studentId);
        if (student == null) {
            System.out.println("Student ID not found.");
            return;
        }
        System.out.print("Enter course code to register: ");
        String courseCode = scanner.nextLine();
        Course course = courseDatabase.get(courseCode);
        if (course == null) {
            System.out.println("Course code not found.");
            return;
        }
        if (course.isAvailable()) {
            if (student.registeredCourses.contains(courseCode)) {
                System.out.println("You are already registered for this course.");
            } else {
                student.registeredCourses.add(courseCode);
                course.enrolled++;
                System.out.println("Registered successfully.");
            }
        } else {
            System.out.println("Course is full.");
        }
    }

    // Method for student to drop a registered course
    static void dropCourse(String studentId, Scanner scanner) {
        Student student = studentDatabase.get(studentId);
        if (student == null) {
            System.out.println("Student ID not found.");
            return;
        }
        System.out.print("Enter course code to drop: ");
        String courseCode = scanner.nextLine();
        if (student.registeredCourses.contains(courseCode)) {
            student.registeredCourses.remove(courseCode);
            Course course = courseDatabase.get(courseCode);
            course.enrolled--;
            System.out.println("Dropped successfully.");
        } else {
            System.out.println("You are not registered for this course.");
        }
    }
}
// Code by Vivek Auti