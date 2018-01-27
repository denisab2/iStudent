package ro.ubb.istudent.service.evaluable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.IQuestion;
import ro.ubb.istudent.domain.Quizz;
import ro.ubb.istudent.repository.QuizzRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 26.01.2018.
 */
@Service
public class QuizzServiceImpl implements QuizzService {

    private static final Logger logger = LoggerFactory.getLogger(QuizzServiceImpl.class);

    @Autowired
    private QuizzRepository quizzRepository;

    @Override
    public List<Quizz> findAll() {
        logger.trace("finding all quizzes");
        List<Quizz> quizzes = quizzRepository.findAll();
        logger.trace("quizzes={}", quizzes);
        return quizzes;
    }

    @Override
    public Quizz save(Map<IQuestion, String> questionPool, float requiredScore) {
        logger.trace("creating quizz: questionPool={}, requiredScore={}", questionPool, requiredScore);
        Quizz quizz = Quizz.builder()
                           .requiredScore(0.5f)
                           .questionPool(questionPool)
                           .build();
        quizz = quizzRepository.save(quizz);
        logger.trace("created quizz={}", quizz);
        return quizz;
    }

}