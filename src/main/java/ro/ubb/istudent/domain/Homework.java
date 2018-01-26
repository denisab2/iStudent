package ro.ubb.istudent.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Created by Administrator on 26.01.2018.
 */
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(onConstructor = @__({@Builder}))
public class Homework implements Evaluable {

    @Id
    private ObjectId homeworkId;

    @NonNull
    protected Date deadline;

    @NonNull
    protected Integer delayedDays;

    @Override
    public float evaluate() {
        return Math.max(0f, 1 - (0.1f * delayedDays));
    }

    @Override
    public boolean passed() {
        return evaluate() > 0.5f && delayedDays < 10;
    }
}
