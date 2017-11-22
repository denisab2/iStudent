package ro.ubb.istudent.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * Created by Deni on 22/11/2017.
 */

@Document(collection = "questions")
public class Question implements Serializable, IQuestion {

    @Id
    private ObjectId questionId;

    private String text;

    private String correctAnswer;

    private ObjectId examId;

    public Question(ObjectId questionId, String text, String correctAnswer, ObjectId examId) {
        this.questionId = questionId;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.examId = examId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!questionId.equals(question.questionId)) return false;
        if (text != null ? !text.equals(question.text) : question.text != null) return false;
        if (correctAnswer != null ? !correctAnswer.equals(question.correctAnswer) : question.correctAnswer != null)
            return false;
        return examId != null ? examId.equals(question.examId) : question.examId == null;
    }

    @Override
    public int hashCode() {
        int result = questionId.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }


    public String PrintQuestion() {
        return "Question{" +
                "questionId=" + questionId +
                ", text='" + text + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", examId=" + examId +
                '}';
    }

    @Override
    public boolean checkAnswer(String answer) {
        if(answer.equals(this.correctAnswer))
            return true;
        return false;
    }

    public ObjectId getQuestionId() {
        return questionId;
    }

    public void setQuestionId(ObjectId questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ObjectId getExamId() {
        return examId;
    }

    public void setExamId(ObjectId examId) {
        this.examId = examId;
    }
}
