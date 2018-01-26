package ro.ubb.istudent.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.ubb.istudent.domain.Quizz;

/**
 * Created by Administrator on 26.01.2018.
 */
public interface QuizzRepository extends MongoRepository<Quizz, ObjectId> {
}
