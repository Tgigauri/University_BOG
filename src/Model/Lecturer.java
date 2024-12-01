package Model;

import java.util.List;

public class Lecturer extends Person{

    private String lecturerNumber;
    private List<Course> taughtCourses;

    public void assignCourse(Course course){};
    public void removeCourse(Course course){};
    public Lecturer(int id, String firstName, String lastName, String email, String lecturerNumber, List<Course> taughtCourses) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.lecturerNumber = lecturerNumber;
        this.taughtCourses = taughtCourses;
    }
    public String getLecturerNumber() {
        return lecturerNumber;
    }

    public void setLecturerNumber(String lecturerNumber) {
        this.lecturerNumber = lecturerNumber;
    }

    public List<Course> getTaughtCourses() {
        return taughtCourses;
    }

    public void setTaughtCourses(List<Course> taughtCourses) {
        this.taughtCourses = taughtCourses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lecturer{")
                .append("lecturerNumber='").append(lecturerNumber).append('\'')
                .append(", firstName='").append(firstName).append('\'')
                .append(", lastName='").append(lastName).append('\'')
                .append(", email='").append(email).append('\'')
                .append('}');
        return sb.toString();
    }

}
