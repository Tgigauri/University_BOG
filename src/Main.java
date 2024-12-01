import Interface.UniversityManagement;
import Model.*;
import Exception.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        University universityManagement = new University();
        List<Course> courses = new ArrayList<>();
        Lecturer lecturer = new Lecturer(2, "Tomas", "Jalaki", "tomasj@techincalUniversity.edu.ge", "02", courses);
        Lecturer lecturer1 = new Lecturer(3, "Gedevan", "Gudastviri", "GGGDDD@Freeuni.edu.ge", "03", courses);

        Date startDate = new Date(2024, 3, 15);
        Date endDate = new Date(2025, 1, 31);
        List<String> weekDays = new ArrayList<>();
        weekDays.add("Monday");
        weekDays.add("Tuesday");
        weekDays.add("Wednesday");
        Course course = new Course(1, "Math", lecturer, startDate, weekDays, endDate);
        Course course2 = new Course(2, "Chemistry", lecturer1, startDate, weekDays, endDate);
        courses.add(course);
        Student student = new Student(1, "Tornike", "Gigauri", "togigauri@bog.ge", "01", courses, 3.5);
        Student student1 = new Student(2, "Mitch", "Mcdonald", "mMcdonald@tbc.ge", "02", courses, 3.7);

        System.out.println("\nTASK 1");
        // Task 1.1
        universityManagement.addStudent(student);
        // Task 1.2
        System.out.println(universityManagement.getStudentById("01"));
        // Task 1.3
        student.setGPA(3.0);
        System.out.println(universityManagement.getStudentById("01"));
        // Task 1.4
//        universityManagement.removeStudent(student); // ექსეფშენის შესამოწმებლად კომენტარი უნდა მოიხსნას
//        System.out.println(universityManagement.getStudentById("01"));

        System.out.println("\nTASK 2");
        // Task 2.1
        universityManagement.addLecturer(lecturer);
        // Task 2.2
        System.out.println(universityManagement.getLecturerById("02"));
        System.out.println(universityManagement.getLecturerByName("Tomas"));
        // Task 2.3
        lecturer.setEmail("NewMailWhoDis@gmail.com");
        System.out.println(universityManagement.getLecturerByName("Tomas"));
        // Task 2.4
//        universityManagement.removeLecturer(lecturer);// ექსეფშენის შესამოწმებლად კომენტარი უნდა მოიხსნას
//        System.out.println(universityManagement.getLecturerByName("Tomas"));

        System.out.println("\nTASK 3");
        // Task 3.1
        universityManagement.addCourse(course);
        // Task 3.2
        System.out.println(universityManagement.getCourseById(1));
        System.out.println(universityManagement.getCourseByName("Math"));
        // Task 3.3
        course.setCourseName("Physics");
        course.setLecturer(lecturer1);
        System.out.println(universityManagement.getCourseByName("Physics"));
        // Task 3.4
        // universityManagement.removeCourse(course); // ექსეფშენის შესამოწმებლად კომენტარი უნდა მოიხსნას
        System.out.println(universityManagement.getCourseByName("Physics"));
        // Task 3.5
        course.addStudent(student);
        System.out.println(universityManagement.getCourseByName("Physics"));
        course.removeStudent(student);
        System.out.println(universityManagement.getCourseByName("Physics"));
        // Task 3.6
        course.setLecturer(lecturer);
        System.out.println(universityManagement.getCourseByName("Physics"));

        System.out.println("\nTASK 4");
        // Task 4.1
        universityManagement.addStudent(student);
        universityManagement.addStudent(student1);
        universityManagement.getStudents();
        // Task 4.2
        universityManagement.addLecturer(lecturer);
        universityManagement.addLecturer(lecturer1);
        universityManagement.getLecturers();
        // Task 4.3
        universityManagement.getCourses();
        // Task 4.4
        course.addStudent(student);
        try {
            System.out.println(universityManagement.getCoursesByStudent(student));
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Task 4.5
        try {
            System.out.println(universityManagement.getCoursesByLecturer(lecturer));
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
