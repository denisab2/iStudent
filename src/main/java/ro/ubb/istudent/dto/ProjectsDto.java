package ro.ubb.istudent.dto;

import lombok.*;
import ro.ubb.istudent.domain.Project;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M. B. on 1/23/2018.
 */
@Getter
@Setter
@ToString
public class ProjectsDto implements Dto {

    @NonNull
    private final List<ProjectDto> dtos;

    @Builder
    private ProjectsDto(List<Project> projects) {
        dtos = projects.stream()
                .map(project -> ProjectDto.builder()
                        .projectId(project.getProjectId()
                                .toString())
                .contentSize(project.getContentSize())
                .contentQuality(project.getContentQuality())
                .topicStrength(project.getTopicStrength())
                .build())
                .collect(Collectors.toList());
    }

}
