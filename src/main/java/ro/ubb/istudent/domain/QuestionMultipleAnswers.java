package ro.ubb.istudent.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deni on 23/11/2017.
 */
public class QuestionMultipleAnswers extends QuestionDecorator{

    private List<String> answers;

    public QuestionMultipleAnswers(Question question){
        super(question);
        answers  = new ArrayList<>();
    }

    @Override
    public String PrintQuestion() {
        String ans = "";
        for (String s : answers)
            ans += answers + "\n";
        return super.PrintQuestion() + "\n" + ans;
    }

    @Override
    public boolean checkAnswer(String answer) {
        if(super.checkAnswer(answer))
            return true;
        for (int i = 0; i< answers.size(); i++){
            int answerIndex = Integer.parseInt(answer);
            if (answers.get(i).equals(super.getCorrectAnswer()) && i == answerIndex)
                return true;

        }
        return false;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
