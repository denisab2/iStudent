package ro.ubb.istudent.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Validation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 26.01.2018.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Validation("{ contentQuality : { $gt : 0 } }")
@Document(collection = "project")
public class Project implements Evaluable {

    @Id
    private ObjectId projectId;

    @NonNull
    private Float contentQuality;

    @NonNull
    private Float contentSize;

    @NonNull
    private Float topicStrength;

    @Builder
    private Project(@NonNull final Float contentSize, @NonNull final Float contentQuality, @NonNull final Float
            topicStrength) {
        this.contentSize = contentSize;
        this.contentQuality = contentQuality;
        this.topicStrength = topicStrength;
    }

    @Override
    public float evaluate() {
        return Math.min(1f, Math.max(0f, 0.1f + topicStrength + contentSize / contentQuality));
    }

    @Override
    public boolean passed() {
        return evaluate() > 0.4f;
    }

}
