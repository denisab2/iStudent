package ro.ubb.istudent.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Question;
import ro.ubb.istudent.dto.QuestionDto;
import ro.ubb.istudent.repository.QuestionRepository;

import java.util.Optional;

@Service
public class QuestionService {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionService.class);
    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Optional<QuestionDto> findQuestionById(String questionId) {
        return repository.findQuestionByQuestionId(questionId)
                .map(QuestionService::questionToQuestionDTO);
    }

    public void updateQuestionById(String questionId, QuestionDto request) {
        Optional<Question> optionalQuestion = repository.findQuestionByQuestionId(questionId);
        if (optionalQuestion.isPresent()) {
            Question questionEntity = optionalQuestion.get();
            questionEntity.setCorrectAnswer(request.getCorrectAnswer());
            questionEntity.setText(request.getText());
            repository.save(questionEntity);
        } else {
            LOG.error("Question with id {} not found", questionId);
        }
    }

    public void deleteQuestionById(String questionId) {
        Optional<Question> optionalQuestion = repository.findQuestionByQuestionId(questionId);
        if (optionalQuestion.isPresent()) {
            repository.delete(optionalQuestion.get());
        } else {
            LOG.error("Question with id {} not found", questionId);
        }
    }

    public QuestionDto saveQuestion(QuestionDto question) {
        return questionToQuestionDTO(repository.save(questionDTOToQuestion(question)));
    }

    public static QuestionDto questionToQuestionDTO(Question entity) {
        QuestionDto dto = new QuestionDto(entity.getQuestionId().toString(),entity.getText(),entity.getCorrectAnswer());
        return dto;
    }

    public static Question questionDTOToQuestion(QuestionDto dto) {
        Question entity = new Question(new ObjectId(dto.getQuestionId()),dto.getText(),dto.getCorrectAnswer());
        return entity;
    }
}
