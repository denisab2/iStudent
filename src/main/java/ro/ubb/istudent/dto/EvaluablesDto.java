package ro.ubb.istudent.dto;

import lombok.*;
import ro.ubb.istudent.domain.Evaluable;
import ro.ubb.istudent.domain.Homework;
import ro.ubb.istudent.domain.Project;
import ro.ubb.istudent.domain.Quizz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M. B. on 1/23/2018.
 */
@Getter
@Setter
@ToString
public class EvaluablesDto implements Dto {

    @NonNull
    private final List<Dto> dtos;

    @Builder
    private EvaluablesDto(List<Evaluable> data) {
        dtos = new ArrayList<>();
        dtos.addAll(ProjectsDto.builder()
                .projects(data.stream()
                        .filter(entity -> entity instanceof Project)
                        .map(entity -> (Project) entity)
                        .collect(Collectors.toList()))
                .build()
                .getDtos());
        dtos.addAll(HomeworksDto.builder()
                .data(data.stream()
                        .filter(entity -> entity instanceof Homework)
                        .map(entity -> (Homework) entity)
                        .collect(Collectors.toList()))
                .build()
                .getDtos());
        dtos.addAll(QuizzesDto.builder()
                .quizzes(data.stream()
                        .filter(entity -> entity instanceof Quizz)
                        .map(entity -> (Quizz) entity)
                        .collect(Collectors.toList()))
                .build()
                .getDtos());
    }

}
