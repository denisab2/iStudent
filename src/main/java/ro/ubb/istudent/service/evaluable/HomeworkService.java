package ro.ubb.istudent.service.evaluable;

import lombok.NonNull;
import ro.ubb.istudent.domain.Homework;

import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 26.01.2018.
 */
public interface HomeworkService {

    @NonNull
    List<Homework> findAll();

    @NonNull
    Homework create(@NonNull final Date deadLine, @NonNull final Integer delayedDays);

    @NonNull
    Homework save(@NonNull final Homework homework);

}
