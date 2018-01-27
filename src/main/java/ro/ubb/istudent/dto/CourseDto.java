package ro.ubb.istudent.dto;

import ro.ubb.istudent.domain.CourseWeek;
import ro.ubb.istudent.domain.Quizz;

import java.util.ArrayList;
import java.util.List;

public class CourseDto implements Dto {

    private String idCourse;

    private String nameCourse;

    private Boolean isPublished;

    private String teacherId;

    private List<Quizz> exams = new ArrayList<>();

    private List<CourseWeek> courseWeeks = new ArrayList<>();

    private List<AssignmentDto> assignments;

    public CourseDto(String nameCourse, Boolean isPublished, String teacherId) {
        this.nameCourse = nameCourse;
        this.isPublished = isPublished;
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseDto course = (CourseDto) o;

        if (!idCourse.equals(course.idCourse)) return false;
        if (nameCourse != null ? !nameCourse.equals(course.nameCourse) : course.nameCourse != null) return false;
        if (isPublished != null ? !isPublished.equals(course.isPublished) : course.isPublished != null) return false;
        return teacherId != null ? teacherId.equals(course.teacherId) : course.teacherId == null;
    }

    @Override
    public int hashCode() {
        int result = idCourse.hashCode();
        result = 31 * result + (nameCourse != null ? nameCourse.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "idCourse=" + idCourse +
                ", nameCourse='" + nameCourse + '\'' +
                ", isPublished=" + isPublished +
                ", teacherId=" + teacherId +
                ", assignments=" + assignments +
                '}';
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public List<Quizz> getExams() {
        return exams;
    }

    public void setExams(List<Quizz> exams) {
        this.exams = exams;
    }

    public List<CourseWeek> getCourseWeeks() {
        return courseWeeks;
    }

    public void setCourseWeeks(List<CourseWeek> courseWeeks) {
        this.courseWeeks = courseWeeks;
    }
}
