package ro.ubb.istudent.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.ubb.istudent.domain.GreetingEntity;
import ro.ubb.istudent.domain.Lecture;

/**
 * Created by Deni on 23/11/2017.
 */
public interface LectureRepository   extends MongoRepository<Lecture, ObjectId> {
}
