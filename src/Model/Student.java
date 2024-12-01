package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Student extends Person{
    private String studentNumber;
    private List<Course> enrolledCourses;
    private Double GPA;
    public void enrollInCourse(Course course){};
    public void withdrawFromCourse(Course course){};
    public void getGPA(){};
    Database database;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{")
                .append("studentNumber='").append(studentNumber).append('\'')
                .append(", GPA=").append(GPA)
                .append(", firstName='").append(firstName).append('\'')
                .append(", lastName='").append(lastName).append('\'')
                .append(", email='").append(email).append('\'')
                .append('}');
        return sb.toString();
    }


    public Student() {
    }

    public Student(
            @JsonProperty("id") int id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("email") String email,
            @JsonProperty("studentNumber") String studentNumber,
            @JsonProperty("enrolledCourses") List<Course> enrolledCourses,
            @JsonProperty("GPA") Double GPA) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentNumber = studentNumber;
        this.enrolledCourses = enrolledCourses;
        this.GPA = GPA;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentNumber, student.studentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber);
    }


}
