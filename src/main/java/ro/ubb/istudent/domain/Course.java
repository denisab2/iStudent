package ro.ubb.istudent.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Deni on 21/11/2017.
 */

@Document(collection = "courses")
public class Course implements Serializable {

    @Id
    private ObjectId idCourse;

    private String nameCourse;

    private Boolean isPublished;

    private ObjectId teacherId;

    @DBRef
    private List<Assignment> assignments;

    public Course(String nameCourse, Boolean isPublished, ObjectId teacherId) {
        this.nameCourse = nameCourse;
        this.isPublished = isPublished;
        this.teacherId = teacherId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

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

    public ObjectId getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(ObjectId idCourse) {
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

    public ObjectId getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(ObjectId teacherId) {
        this.teacherId = teacherId;
    }
}
