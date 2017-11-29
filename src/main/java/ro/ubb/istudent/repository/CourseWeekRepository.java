
package ro.ubb.istudent.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.ubb.istudent.domain.CourseWeek;

/**
 * Created by Deni on 23/11/2017.
 */
public interface CourseWeekRepository   extends MongoRepository<CourseWeek, ObjectId> {

}
