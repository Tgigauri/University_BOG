package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private Lecturer lecturer;
    List<Student> enrolledStudents = new ArrayList<>();
    private Date startDate;

    private List<String> getWeekDays;
    private Date endDate;
    public void addStudent(Student student){
        enrolledStudents.add(student);
    };
    public void removeStudent(Student student){
        enrolledStudents.remove(student);
    };

    public Course(int courseId, String courseName, Lecturer lecturer, Date startDate, List<String> getWeekDays, Date endDate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.lecturer = lecturer;
        this.startDate = startDate;
        this.getWeekDays = getWeekDays;
        this.endDate = endDate;
        this.enrolledStudents = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course{")
                .append("courseId=").append(courseId)
                .append(", courseName='").append(courseName).append('\'')
                .append(", lecturer=").append(lecturer)
                .append(", enrolledStudents=").append(enrolledStudents)
                .append(", startDate=").append(startDate)
                .append(", getWeekDays=").append(getWeekDays)
                .append(", endDate=").append(endDate)
                .append('}');
        return sb.toString();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<String> getGetWeekDays() {
        return getWeekDays;
    }

    public void setGetWeekDays(List<String> getWeekDays) {
        this.getWeekDays = getWeekDays;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
