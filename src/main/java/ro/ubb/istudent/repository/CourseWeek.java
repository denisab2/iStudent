package ro.ubb.istudent.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.ubb.istudent.domain.GreetingEntity;

/**
 * Created by Deni on 23/11/2017.
 */
public interface CourseWeek   extends MongoRepository<GreetingEntity, ObjectId> {
}
