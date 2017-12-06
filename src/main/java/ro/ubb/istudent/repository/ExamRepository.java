package ro.ubb.istudent.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.ubb.istudent.domain.Exam;

import java.util.Optional;

/**
 * Created by Deni on 23/11/2017.
 */
public interface ExamRepository   extends MongoRepository<Exam, ObjectId> {
    Optional<Exam> findExamByExamId(String examId);
}
