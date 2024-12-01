package Model;
import Exception.*;
import Interface.UniversityManagement;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class University implements UniversityManagement {

    private static List<Student> studentsList = new ArrayList<>();
    private static List<Lecturer> lecturers = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    @Override
    public Course getCourseById(int id) {
        return courses.stream()
                .filter(e -> e.getCourseId() == id)
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException("Course with ID " + id + " not found"));

    }

    @Override
    public Course getCourseByName(String name) {
        return courses.stream()
                .filter(e -> e.getCourseName().equals(name))
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException("Course with Name " + name + " not found"));
    }

    @Override
    public void addStudent(Student student) {
        studentsList.add(student);
    }

    @Override
    public void getStudents() {
        System.out.println(studentsList);
    }

    @Override
    public Student getStudentById(String id) {
        return studentsList.stream()
                .filter(e -> e.getStudentNumber().equals(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    @Override
    public void removeStudent(Student student) {
        studentsList.remove(student);
    }

    @Override
    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    @Override
    public Lecturer getLecturerById(String id) {
        return lecturers.stream()
                .filter(e -> e.getLecturerNumber().equals(id))
                .findFirst()
                .orElseThrow(() -> new LecturerNotFoundException("Lecturer with ID " + id + " not found"));
    }

    @Override
    public Lecturer getLecturerByName(String name) {
        return lecturers.stream()
                .filter(e -> e.getFirstName().equals(name))
                .findFirst()
                .orElseThrow(() -> new LecturerNotFoundException("Lecturer with Name " + name + " not found"));
    }

    @Override
    public void removeLecturer(Lecturer lecturer) {
        lecturers.remove(lecturer);
    }

    @Override
    public void getLecturers() {
        System.out.println(lecturers);
    }

    @Override
    public void getCourses() {
        System.out.println(courses);
    }

    public List<Course> getCoursesByStudent(Student student) {
        List<Course> enrolledCourses = courses.stream()
                .filter(course -> course.getEnrolledStudents().contains(student))
                .collect(Collectors.toList());

        if (enrolledCourses.isEmpty()) {
            throw new CourseNotFoundException("Student with ID " + student.getStudentNumber() + " is not enrolled in any courses");
        }

        return enrolledCourses;
    }

    @Override
    public List<Course> getCoursesByLecturer(Lecturer lecturer) {
        List<Course> lecturerCourses = courses.stream()
                .filter(course -> course.getLecturer().equals(lecturer))
                .collect(Collectors.toList());

        if (lecturerCourses.isEmpty()) {
            throw new CourseNotFoundException("Lecturer with ID " + lecturer.getLecturerNumber() + " is not teaching any courses");
        }
        return lecturerCourses;
    }

    @Override
    public void addStudentFromJson(String filePath) {
        System.out.println("Started Reading Json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Student student = objectMapper.readValue(new File(filePath), Student.class);
            addStudent(student);
            System.out.println("Successfully imported JSON");
        } catch (IOException e) {
            System.out.println("Error parsing student JSON from file: " + e.getMessage());
        }
    }
}
