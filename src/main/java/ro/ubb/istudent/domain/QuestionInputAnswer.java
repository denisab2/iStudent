package ro.ubb.istudent.domain;

import java.util.ArrayList;

/**
 * Created by Deni on 23/11/2017.
 */
public class QuestionInputAnswer  extends QuestionDecorator {

    public QuestionInputAnswer(Question question){
        super(question);
    }

    @Override
    public String PrintQuestion() {
        return super.PrintQuestion() + "\n" +"Introduce your answer: ";
    }

    @Override
    public boolean checkAnswer(String answer) {
        if(super.checkAnswer(answer))
            return true;
        if(answer.toLowerCase().equals(super.getCorrectAnswer().toLowerCase()))
            return true;
        return false;

    }

}
