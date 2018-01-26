package ro.ubb.istudent.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by Administrator on 26.01.2018.
 */
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(onConstructor = @__({@Builder}))
public class Project implements Evaluable {

    @Id
    private ObjectId projectId;

    @NonNull
    private Float contentQuality;

    @NonNull
    private Float contentSize;

    @NonNull
    private Float topicStrength;

    @Override
    public float evaluate() {
        return Math.min(1f, Math.max(0f, 0.1f + topicStrength + contentSize / contentQuality));
    }

    @Override
    public boolean passed() {
        return evaluate() > 0.4f;
    }

    public static void main(String[] args) {
        Project project = Project.builder()
                                 .contentSize(0.3F)
                                 .contentQuality(0.5F)
                                 .topicStrength(0.1F)
                                 .build();
        System.out.printf("project=%s%n", project);
    }

}
