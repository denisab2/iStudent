package ro.ubb.istudent.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Teacher;
import ro.ubb.istudent.dto.TeacherDto;
import ro.ubb.istudent.repository.TeacherRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private static final Logger LOG = LoggerFactory.getLogger(TeacherService.class);
    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public Optional<TeacherDto> findTeacherById(String teacherId) {
        return repository.findTeacherById(teacherId)
                .map(this::teacherToTeacherDTO);
    }

    public void updateTeacherWithId(String teacherId, TeacherDto request) {
        Optional<Teacher> optionalTeacher = repository.findTeacherById(teacherId);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacher.setCourses(request.getCourses().stream()
                    .map(CourseService::CourseDTOToEntity).collect(Collectors.toList()));
            teacher.setName(request.getName());
            repository.save(teacher);
        } else {
            LOG.error("Teacher with id {} not found", teacherId);
        }
    }

    public void deleteTeacherById(String teacherId) {
        Optional<Teacher> optionalTeacher = repository.findTeacherById(teacherId);
        if (optionalTeacher.isPresent()) {
            repository.delete(optionalTeacher.get());
        } else {
            LOG.error("Teacher with id {} not found", teacherId);
        }
    }

    public TeacherDto createTeacher(TeacherDto teacher) {
        return teacherToTeacherDTO(repository.save(teacherDTOToTeacher(teacher)));
    }

    private TeacherDto teacherToTeacherDTO(Teacher entity) {
        TeacherDto dto = new TeacherDto(entity.getName());
        dto.setIdTeacher(entity.getIdTeacher().toHexString());
        dto.setCourses(entity.getCourses().stream()
                .map(CourseService::CourseToCourseDTO).collect(Collectors.toList()));
        return dto;
    }

    private Teacher teacherDTOToTeacher(TeacherDto dto) {
        Teacher entity = new Teacher(dto.getName());
        entity.setCourses(dto.getCourses().stream()
                .map(CourseService::CourseDTOToEntity).collect(Collectors.toList()));
        entity.setIdTeacher(new ObjectId(dto.getIdTeacher()));
        return entity;
    }
}
