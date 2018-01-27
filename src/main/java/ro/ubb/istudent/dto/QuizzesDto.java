package ro.ubb.istudent.dto;

import lombok.*;
import ro.ubb.istudent.domain.Quizz;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M. B. on 1/23/2018.
 */
@Getter
@Setter
@ToString
public class QuizzesDto implements Dto {

    @NonNull
    private final List<QuizzDto> dtos;

    @Builder
    private QuizzesDto(List<Quizz> quizzes) {
        dtos = quizzes.stream()
                .map(project -> QuizzDto.builder()
                        .questionPool(project.getQuestionPool()
                                .keySet()
                                .stream()
                                .collect(Collectors.toMap(key -> UQuestionDto.builder()
                                        .text(key.PrintQuestion())
                                        .answer(key.getCorrectAnswer())
                                        .build(), value -> project.getQuestionPool()
                                        .get(value))))
                        .requiredScore(project.getRequiredScore())
                        .build())
                .collect(Collectors.toList());
    }

}
