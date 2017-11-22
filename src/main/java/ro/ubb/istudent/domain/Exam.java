package ro.ubb.istudent.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Deni on 22/11/2017.
 */

@Document(collection = "exams")
public class Exam implements Serializable {

    @Id
    private ObjectId examId;

    private String type;

    private Integer points;

    private ObjectId idCourse;

    @DBRef
    private List<Question> questions;


    public Exam(ObjectId examId, String type, Integer points, ObjectId idCourse, List<Question> questions) {
        this.examId = examId;
        this.type = type;
        this.points = points;
        this.idCourse = idCourse;
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        if (!examId.equals(exam.examId)) return false;
        if (type != null ? !type.equals(exam.type) : exam.type != null) return false;
        if (points != null ? !points.equals(exam.points) : exam.points != null) return false;
        if (idCourse != null ? !idCourse.equals(exam.idCourse) : exam.idCourse != null) return false;
        return questions != null ? questions.equals(exam.questions) : exam.questions == null;
    }

    @Override
    public int hashCode() {
        int result = examId.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", type='" + type + '\'' +
                ", points=" + points +
                ", idCourse=" + idCourse +
                ", questions=" + questions +
                '}';
    }

    public ObjectId getExamId() {
        return examId;
    }

    public void setExamId(ObjectId examId) {
        this.examId = examId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public ObjectId getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(ObjectId idCourse) {
        this.idCourse = idCourse;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
