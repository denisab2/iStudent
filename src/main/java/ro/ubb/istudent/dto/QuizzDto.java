package ro.ubb.istudent.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.ubb.istudent.domain.Quizz;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by M. B. on 1/23/2018.
 */
@Getter
@Setter
@ToString
@Builder
public class QuizzDto implements Dto {

    private Map<UQuestionDto, String> questionPool;
    private float requiredScore;

    public Quizz get() {
        return Quizz.builder()
                .questionPool(questionPool.keySet()
                        .stream()
                        .collect(Collectors.toMap(UQuestionDto::get, value -> questionPool.get(value))))
                .requiredScore(requiredScore)
                .build();
    }

}
