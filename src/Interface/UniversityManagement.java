package Interface;

import Model.Course;
import Model.Lecturer;
import Model.Student;

import java.util.List;

public interface UniversityManagement {
    void addCourse(Course course);
    void removeCourse(Course course);
    Course getCourseById(int id);
    Course getCourseByName(String name);

    void addStudent(Student student);
    void getStudents();
    Student getStudentById(String id);
    void removeStudent(Student student);

    void addLecturer(Lecturer lecturer);
    Lecturer getLecturerById(String id);
    Lecturer getLecturerByName(String name);
    void removeLecturer(Lecturer lecturer);

    void getLecturers();
    void getCourses();

    List<Course> getCoursesByStudent(Student student);
    List<Course> getCoursesByLecturer(Lecturer lecturer);
    void addStudentFromJson(String studentJson);
}

