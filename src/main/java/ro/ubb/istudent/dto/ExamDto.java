package ro.ubb.istudent.dto;

import org.bson.types.ObjectId;

import java.util.List;

public class ExamDto implements Dto {

    private ObjectId examId;

    private String type;

    private Integer points;

    private ObjectId idCourse;

    private List<QuestionDto> questions;


    public ExamDto(ObjectId examId, String type, Integer points, ObjectId idCourse, List<QuestionDto> questions) {
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

        ExamDto exam = (ExamDto) o;

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
        return "ExamDto{" +
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

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
