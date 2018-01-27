package ro.ubb.istudent.service.evaluable;

import lombok.NonNull;
import ro.ubb.istudent.domain.IQuestion;
import ro.ubb.istudent.domain.Quizz;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 26.01.2018.
 */
public interface QuizzService {

    @NonNull
    List<Quizz> findAll();

    @NonNull
    Quizz save(@NonNull final Map<IQuestion, String> questionPool, @NonNull final float requiredScore);


}
