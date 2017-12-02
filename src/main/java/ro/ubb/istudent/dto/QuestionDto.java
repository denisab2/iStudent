package ro.ubb.istudent.dto;

public class QuestionDto implements Dto, IQuestionDto {

    private String questionId;

    private String text;

    private String correctAnswer;

    public QuestionDto(String questionId,String text, String correctAnswer) {
        this.questionId = questionId;
        this.text = text;
        this.correctAnswer = correctAnswer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionDto question = (QuestionDto) o;

        if (!questionId.equals(question.questionId)) return false;
        if (text != null ? !text.equals(question.text) : question.text != null) return false;
        return !(correctAnswer != null ? !correctAnswer.equals(question.correctAnswer) : question.correctAnswer != null) ;
    }

    @Override
    public int hashCode() {
        int result = questionId.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }


    public String PrintQuestion() {
        return "QuestionDto{" +
                "questionId=" + questionId +
                ", text='" + text + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
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
