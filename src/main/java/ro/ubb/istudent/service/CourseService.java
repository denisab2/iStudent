package ro.ubb.istudent.service;

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
                .map(this::CourseToCourseDTO);
    }

    public void updateCourseWithId(String IdCourse, CourseDto request) {
        Optional<Course> optionalCourseEntity = repository.findCourseByIdCourse(IdCourse);
        if (optionalCourseEntity.isPresent()) {
            Course CourseE = optionalCourseEntity.get();
            CourseE.setNameCourse(request.getNameCourse());
            CourseE.setPublished(request.getPublished());
            CourseE.setTeacherId(request.getTeacherId());
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

    public CourseDto createCourse(CourseDto Course) {
        return CourseToCourseDTO(repository.save(CourseDTOToEntity(Course)));
    }

    private CourseDto CourseToCourseDTO(Course entity) {
        CourseDto dto = new CourseDto(entity.getNameCourse(),entity.getPublished(),entity.getTeacherId());
        dto.setIdCourse(entity.getIdCourse());
        return dto;
    }

    private Course CourseDTOToEntity(CourseDto dto) {
        Course entity = new Course(dto.getNameCourse(),dto.getPublished(),dto.getTeacherId());
        return entity;
    }
}