package ro.ubb.istudent.dto;

import java.util.ArrayList;
import java.util.List;

public class TeacherDto implements Dto {

    private String idTeacher;

    private  String name;

    private List<CourseDto> courses;

    public TeacherDto(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherDto teacher = (TeacherDto) o;

        if (!idTeacher.equals(teacher.idTeacher)) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        return courses != null ? courses.equals(teacher.courses) : teacher.courses == null;
    }

    @Override
    public int hashCode() {
        int result = idTeacher.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeacherDto{" +
                "idTeacher=" + idTeacher +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }
}
