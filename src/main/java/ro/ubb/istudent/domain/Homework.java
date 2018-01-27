package ro.ubb.istudent.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Created by Administrator on 26.01.2018.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "homework")
public class Homework implements Evaluable {

    @Id
    private ObjectId homeworkId;

    @NonNull
    protected Date deadline;

    @NonNull
    protected Integer delayedDays;

    @Builder
    private Homework(@NonNull final Date deadline, @NonNull final Integer delayedDays) {
        this.deadline = deadline;
        this.delayedDays = delayedDays;
    }

    @Override
    public float evaluate() {
        return Math.max(0f, 1 - (0.1f * delayedDays));
    }

    @Override
    public boolean passed() {
        return evaluate() > 0.5f && delayedDays < 10;
    }
}
