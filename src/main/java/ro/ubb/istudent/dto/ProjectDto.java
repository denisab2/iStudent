package ro.ubb.istudent.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by M. B. on 1/27/2018.
 */
@Getter
@Setter
public class ProjectDto implements Dto {

    private String projectId;
    private float contentSize;
    private float contentQuality;
    private float topicStrength;

}
