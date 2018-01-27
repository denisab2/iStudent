package ro.ubb.istudent.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.ubb.istudent.domain.Project;

/**
 * Created by M. B. on 1/23/2018.
 */
@Getter
@Setter
@ToString
@Builder
public class ProjectDto implements Dto {

    private String projectId;
    private float contentSize;
    private float contentQuality;
    private float topicStrength;

    public Project get() {
        return Project.builder()
                .contentSize(contentSize)
                .contentQuality(contentQuality)
                .topicStrength(topicStrength)
                .build();
    }

}
