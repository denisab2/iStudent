package ro.ubb.istudent.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.ubb.istudent.domain.Course;

import java.util.Optional;

/**
 * Created by Deni on 23/11/2017.
 */
public interface CourseRepository   extends MongoRepository<Course, ObjectId> {
    Optional<Course> findCourseByIdCourse(String idCourse);
}
