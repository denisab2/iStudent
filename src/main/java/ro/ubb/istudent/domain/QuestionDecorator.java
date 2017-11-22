package ro.ubb.istudent.domain;

/**
 * Created by Deni on 23/11/2017.
 */
public class QuestionDecorator implements IQuestion{

    protected IQuestion question;

    public QuestionDecorator(Question question){
        this.question = question;
    }

    @Override
    public String PrintQuestion() {
        return question.PrintQuestion();
    }

    @Override
    public boolean checkAnswer(String answer) {
        return question.checkAnswer(answer);

    }

    @Override
    public String getCorrectAnswer() {
        return question.getCorrectAnswer();
    }


}
