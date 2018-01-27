package ro.ubb.istudent.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Course;
import ro.ubb.istudent.domain.CourseWeek;
import ro.ubb.istudent.domain.Teacher;
import ro.ubb.istudent.dto.CourseDto;
import ro.ubb.istudent.exception.EntityNotValidException;
import ro.ubb.istudent.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            if (request.getPublished() && CourseE.getPublished() == false) {
                validate(CourseE);
                CourseE.setPublished(request.getPublished());
            }
            CourseE.setTeacherId(new ObjectId(request.getTeacherId()));
            repository.save(CourseE);
        } else {
            LOG.error("Course with id {} not found", IdCourse);
        }
    }

    public void validate(Course course) throws EntityNotValidException{
        if (course.getCourseWeeks().isEmpty())
            throw new EntityNotValidException(course.getNameCourse());
        for (CourseWeek week : course.getCourseWeeks())
            if (week.getCourseMaterials().isEmpty())
                throw new EntityNotValidException(course.getNameCourse());
        if (course.getExams().isEmpty())
            throw new EntityNotValidException(course.getNameCourse());
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
        Course course = courseDTOToCourse(Course);
        course.setPublished(false);
        return courseToCourseDTO(repository.save(course));
    }

    public List<CourseDto> findAll(){

        List<CourseDto> courses = repository.findAll().stream().
                map(CourseService::courseToCourseDTO).collect(Collectors.toList());
        LOG.trace("All courses: "  + courses.toString());

        return courses;
    }

    public List<CourseDto> findAllPublished(){
        List<Course> courses = repository.findAll();
        List<Course> coursesPublished = new ArrayList<>();
        for (Course c : courses)
            if(c.getPublished())
                coursesPublished.add(c);
        LOG.trace("Published courses: " + coursesPublished);
        return coursesPublished.stream().map(CourseService::courseToCourseDTO).collect(Collectors.toList());
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