package ro.ubb.istudent.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.ubb.istudent.domain.IQuestion;
import ro.ubb.istudent.domain.Question;

/**
 * Created by M. B. on 1/23/2018.
 */
@Getter
@Setter
@ToString
@Builder
public class UQuestionDto {

    private String text;
    private String answer;

    public IQuestion get() {
        return new Question(null, text, answer);
    }

}
