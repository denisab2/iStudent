package ro.ubb.istudent.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.ubb.istudent.domain.Course;
<<<<<<< HEAD
import ro.ubb.istudent.domain.GreetingEntity;
=======

import java.util.Optional;
>>>>>>> 594f235b68c0fcd382a2fbbec549ba7fe364fa26

/**
 * Created by Deni on 23/11/2017.
 */
public interface CourseRepository   extends MongoRepository<Course, ObjectId> {
<<<<<<< HEAD
=======
    Optional<Course> findCourseByIdCourse(String idCourse);
>>>>>>> 594f235b68c0fcd382a2fbbec549ba7fe364fa26
}
