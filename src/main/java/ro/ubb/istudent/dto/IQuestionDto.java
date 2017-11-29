package ro.ubb.istudent.dto;

public interface IQuestionDto {


    public String PrintQuestion();

    public boolean checkAnswer(String answer);

    public String getCorrectAnswer();
}