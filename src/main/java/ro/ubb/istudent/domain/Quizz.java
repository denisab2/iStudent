package ro.ubb.istudent.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.*;

/**
 * Created by Administrator on 26.01.2018.
 */
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(onConstructor = @__({@Builder}))
public class Quizz implements Evaluable {

    @Id
    private ObjectId quizzId;

    @NonNull
    private final Map<IQuestion, String> questionPool;

    @NonNull
    protected Float requiredScore;

    public Quizz select(@NonNull final IQuestion question, @NonNull final String answer) {
        questionPool.put(question, answer);
        return this;
    }

    public final IQuestion nextQuestion() {
        return questionPool.keySet().stream().filter(question -> Objects.isNull(questionPool.get(question))).findFirst().orElse(null);
    }

    @Override
    public float evaluate() {
        return (float) questionPool.entrySet().stream().filter(question -> Objects.equals(question.getKey().getCorrectAnswer(), question.getValue())).count() / questionPool.size();
    }

    @Override
    public boolean passed() {
        return evaluate() >= requiredScore;
    }

}
