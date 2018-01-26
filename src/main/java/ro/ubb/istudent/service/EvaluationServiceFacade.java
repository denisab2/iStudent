package ro.ubb.istudent.service;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Evaluable;
import ro.ubb.istudent.service.evaluable.HomeworkService;
import ro.ubb.istudent.service.evaluable.ProjectService;
import ro.ubb.istudent.service.evaluable.QuizzService;

import java.util.List;

/**
 * Created by Administrator on 26.01.2018.
 */
public interface EvaluationServiceFacade {

    @NonNull
    List<Evaluable> findAll();

    @NonNull
    Evaluable save(@NonNull final Evaluable evaluable);

}
