package ro.ubb.istudent.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Exam;
import ro.ubb.istudent.dto.ExamDto;
import ro.ubb.istudent.repository.ExamRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamService {

    private static final Logger LOG = LoggerFactory.getLogger(ExamService.class);
    private final ExamRepository repository;

    public ExamService(ExamRepository repository) {
        this.repository = repository;
    }

    public Optional<ExamDto> findExamById(String ExamId) {
        return repository.findExamByExamId(ExamId)
                .map(this::examToExamDTO);
    }

    public void updateExamById(String ExamId, ExamDto request) {
        Optional<Exam> optionalExam = repository.findExamByExamId(ExamId);
        if (optionalExam.isPresent()) {
            Exam examEntity = optionalExam.get();
            examEntity.setPoints(request.getPoints());
            examEntity.setQuestions(request.getQuestions().stream()
                    .map(QuestionService::questionDTOToQuestion).collect(Collectors.toList()));
            examEntity.setType(request.getType());
            repository.save(examEntity);
        } else {
            LOG.error("Exam with id {} not found", ExamId);
        }
    }

    public void deleteExamById(String ExamId) {
        Optional<Exam> optionalExamEntity = repository.findExamByExamId(ExamId);
        if (optionalExamEntity.isPresent()) {
            repository.delete(optionalExamEntity.get());
        } else {
            LOG.error("Exam with id {} not found", ExamId);
        }
    }

    public ExamDto saveExam(ExamDto Exam)
    {
        return examToExamDTO(repository.save(examDTOToExam(Exam)));
    }

    private ExamDto examToExamDTO(Exam entity) {
        ExamDto dto = new ExamDto(entity.getExamId().toHexString(),entity.getType(),
                entity.getPoints(),entity.getQuestions().stream()
                .map(QuestionService::questionToQuestionDTO).collect(Collectors.toList()));
        return dto;
    }

    private Exam examDTOToExam(ExamDto dto) {
        Exam entity = new Exam(new ObjectId(dto.getExamId()),dto.getType(),dto.getPoints(),
                dto.getQuestions().stream()
                        .map(QuestionService::questionDTOToQuestion).collect(Collectors.toList()));
        return entity;
    }
}
