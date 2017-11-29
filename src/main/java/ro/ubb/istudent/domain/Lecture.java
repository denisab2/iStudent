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


    public Lecture(ObjectId lectureId, String description, String filePath, ObjectId idCourseWeek) {
        this.lectureId = lectureId;
        this.description = description;
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecture lecture = (Lecture) o;

        if (lectureId != null ? !lectureId.equals(lecture.lectureId) : lecture.lectureId != null) return false;
        if (description != null ? !description.equals(lecture.description) : lecture.description != null) return false;
        return filePath != null ? filePath.equals(lecture.filePath) : lecture.filePath == null;
    }

    @Override
    public int hashCode() {
        int result = lectureId.hashCode();
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureId=" + lectureId +
                ", description='" + description + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
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

}
