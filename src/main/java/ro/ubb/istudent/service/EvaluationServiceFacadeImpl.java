package ro.ubb.istudent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Evaluable;
import ro.ubb.istudent.domain.Homework;
import ro.ubb.istudent.domain.Project;
import ro.ubb.istudent.domain.Quizz;
import ro.ubb.istudent.service.evaluable.HomeworkService;
import ro.ubb.istudent.service.evaluable.ProjectService;
import ro.ubb.istudent.service.evaluable.QuizzService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 26.01.2018.
 */
@Service
public class EvaluationServiceFacadeImpl implements EvaluationServiceFacade {

    private static final Logger logger = LoggerFactory.getLogger(EvaluationServiceFacade.class);

    @Autowired
    private QuizzService quizzService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private ProjectService projectService;

    @Override
    public List<Evaluable> findAll() {
        logger.trace("finding all evaluables");
        List<Evaluable> evaluables = new ArrayList<>();
        List<Quizz> quizzes = quizzService.findAll();
        logger.trace("quizzes={}", quizzes);
        List<Homework> homeworks = homeworkService.findAll();
        logger.trace("homeworks={}", homeworks);
        List<Project> projects = projectService.findAll();
        logger.trace("projects={}", projects);
        evaluables.addAll(quizzes);
        evaluables.addAll(homeworks);
        evaluables.addAll(projects);
        return evaluables;
    }

    @Override
    public Evaluable save(Evaluable evaluable) {
        logger.trace("saving evaluable={}", evaluable);
        if (evaluable instanceof Quizz) {
            evaluable = quizzService.save((Quizz) evaluable);
        } else if (evaluable instanceof Homework) {
            evaluable = homeworkService.save((Homework) evaluable);
        } else if (evaluable instanceof Project) {
            evaluable = projectService.save((Project) evaluable);
        } else {
            throw new NotImplementedException();
        }
        logger.trace("saved evaluable={}", evaluable);
        return evaluable;
    }
}
