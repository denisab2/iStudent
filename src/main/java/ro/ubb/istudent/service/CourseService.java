package ro.ubb.istudent.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Course;
import ro.ubb.istudent.dto.CourseDto;
import ro.ubb.istudent.repository.CourseRepository;

import java.util.Optional;

@Service
public class CourseService {

    private static final Logger LOG = LoggerFactory.getLogger(CourseService.class);
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Optional<CourseDto> findCourseById(String IdCourse) {
        return repository.findCourseByIdCourse(IdCourse)
                .map(CourseService::courseToCourseDTO);
    }

    public void updateCourseById(String IdCourse, CourseDto request) {
        Optional<Course> optionalCourseEntity = repository.findCourseByIdCourse(IdCourse);
        if (optionalCourseEntity.isPresent()) {
            Course CourseE = optionalCourseEntity.get();
            CourseE.setNameCourse(request.getNameCourse());
            CourseE.setPublished(request.getPublished());
            CourseE.setTeacherId(new ObjectId(request.getTeacherId()));
            repository.save(CourseE);
        } else {
            LOG.error("Course with id {} not found", IdCourse);
        }
    }

    public void deleteCourseById(String CourseId) {
        Optional<Course> optionalCourseEntity = repository.findCourseByIdCourse(CourseId);
        if (optionalCourseEntity.isPresent()) {
            repository.delete(optionalCourseEntity.get());
        } else {
            LOG.error("Course with id {} not found", CourseId);
        }
    }

    public CourseDto saveCourse(CourseDto Course) {
        return courseToCourseDTO(repository.save(courseDTOToCourse(Course)));
    }

    public static CourseDto courseToCourseDTO(Course entity) {
        CourseDto dto = new CourseDto(entity.getNameCourse(),entity.getPublished(),entity.getTeacherId().toHexString());
        dto.setIdCourse(entity.getIdCourse().toHexString());
        return dto;
    }

    public static Course courseDTOToCourse(CourseDto dto) {
        Course entity = new Course(dto.getNameCourse(),dto.getPublished(),new ObjectId(dto.getTeacherId()));
        entity.setIdCourse(new ObjectId(dto.getIdCourse()));
        return entity;
    }
}