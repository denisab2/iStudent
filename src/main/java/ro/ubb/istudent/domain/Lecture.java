package ro.ubb.istudent.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Deni on 22/11/2017.
 */

@Document(collection = "lectures")
public class Lecture implements Serializable {

    @Id
    private ObjectId lectureId;

    private String description;

    private String filePath;

    private ObjectId idCourseWeek;

    public Lecture(ObjectId lectureId, String description, String filePath, ObjectId idCourseWeek) {
        this.lectureId = lectureId;
        this.description = description;
        this.filePath = filePath;
        this.idCourseWeek = idCourseWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecture lecture = (Lecture) o;

        if (!lectureId.equals(lecture.lectureId)) return false;
        if (description != null ? !description.equals(lecture.description) : lecture.description != null) return false;
        if (filePath != null ? !filePath.equals(lecture.filePath) : lecture.filePath != null) return false;
        return idCourseWeek != null ? idCourseWeek.equals(lecture.idCourseWeek) : lecture.idCourseWeek == null;
    }

    @Override
    public int hashCode() {
        int result = lectureId.hashCode();
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        return result;
    }

    public ObjectId getLectureId() {
        return lectureId;
    }

    public void setLectureId(ObjectId lectureId) {
        this.lectureId = lectureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ObjectId getIdCourseWeek() {
        return idCourseWeek;
    }

    public void setIdCourseWeek(ObjectId idCourseWeek) {
        this.idCourseWeek = idCourseWeek;
    }
}