package ro.ubb.istudent.domain;

import org.bson.types.ObjectId;

/**
 * Created by Deni on 23/11/2017.
 */
public interface IQuestion {


    public String PrintQuestion();

    public boolean checkAnswer(String answer);

    public String getCorrectAnswer();
}
