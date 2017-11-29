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


    public Question(ObjectId questionId, String text, String correctAnswer, ObjectId examId) {
        this.questionId = questionId;
        this.text = text;
        this.correctAnswer = correctAnswer;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (questionId != null ? !questionId.equals(question.questionId) : question.questionId != null) return false;
        if (text != null ? !text.equals(question.text) : question.text != null) return false;
        return correctAnswer != null ? correctAnswer.equals(question.correctAnswer) : question.correctAnswer == null;
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
                '}';
    }

    @Override
    public boolean checkAnswer(String answer) {
        return (answer.equals(this.correctAnswer));
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

}
