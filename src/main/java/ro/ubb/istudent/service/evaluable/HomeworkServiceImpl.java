package ro.ubb.istudent.service.evaluable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Homework;
import ro.ubb.istudent.repository.HomeworkRepository;

import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 26.01.2018.
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {

    private static final Logger logger = LoggerFactory.getLogger(HomeworkServiceImpl.class);

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Override
    public List<Homework> findAll() {
        logger.trace("finding all homeworks");
        List<Homework> homeworks = homeworkRepository.findAll();
        logger.trace("homeworks={}", homeworks);
        return homeworks;
    }

    @Override
    public Homework create(Date deadLine, Integer delayedDays) {
        logger.trace("creating homework: deadline={}, delayedDays={}", deadLine, delayedDays);
        Homework homework = Homework.builder()
                                    .deadline(deadLine)
                                    .delayedDays(delayedDays)
                                    .build();
        homework = homeworkRepository.save(homework);
        logger.trace("created homework={}", homework);
        return homework;
    }

    @Override
    public Homework save(Homework homework) {
        logger.trace("saving homework={}", homework);
        homework = homeworkRepository.save(homework);
        logger.trace("saved homework={}", homework);
        return homework;
    }
}
