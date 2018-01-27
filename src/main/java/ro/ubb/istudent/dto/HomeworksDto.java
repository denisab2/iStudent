package ro.ubb.istudent.dto;

import lombok.*;
import ro.ubb.istudent.domain.Homework;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M. B. on 1/23/2018.
 */
@Getter
@Setter
@ToString
public class HomeworksDto implements Dto {

    @NonNull
    private final List<HomeworkDto> dtos;

    @Builder
    private HomeworksDto(List<Homework> data) {
        dtos = data.stream()
                .map(entity -> HomeworkDto.builder()
                        .deadline(entity.getDeadline())
                        .delayedDays(entity.getDelayedDays())
                        .build())
                .collect(Collectors.toList());
    }

}
