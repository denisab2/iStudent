package ro.ubb.istudent.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.CourseWeek;
import ro.ubb.istudent.dto.CourseWeekDto;
import ro.ubb.istudent.repository.CourseWeekRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseWeekService {

    private static final Logger LOG = LoggerFactory.getLogger(CourseWeekService.class);
    private final CourseWeekRepository repository;

    public CourseWeekService(CourseWeekRepository repository) {
        this.repository = repository;
    }

    public Optional<CourseWeekDto> findCourseWeekById(String CourseWeekId) {
        return repository.findCourseWeekByIdCourseWeek(CourseWeekId)
                .map(this::courseWeekToCourseWeekDTO);
    }

    public void updateCourseWeekById(String CourseWeekId, CourseWeekDto request) {
        Optional<CourseWeek> optionalCourseWeek = repository.findCourseWeekByIdCourseWeek(CourseWeekId);
        if (optionalCourseWeek.isPresent()) {
            CourseWeek courseWeek = optionalCourseWeek.get();
            courseWeek.setCourseMaterials(request.getCourseMaterials().stream()
                    .map(CourseMaterialService::courseMaterialDTOToCourseMaterial).collect(Collectors.toList()));
            courseWeek.setNrOfWeekes(request.getNrOfWeekes());
            courseWeek.setLectures(request.getLectures().stream()
            .map(LectureService::lectureDTOToLecture).collect(Collectors.toList()));
            repository.save(courseWeek);
        } else {
            LOG.error("CourseWeek with id {} not found", CourseWeekId);
        }
    }

    public void deleteCourseWeekById(String CourseWeekId) {
        Optional<CourseWeek> optionalCourseWeek = repository.findCourseWeekByIdCourseWeek(CourseWeekId);
        if (optionalCourseWeek.isPresent()) {
            repository.delete(optionalCourseWeek.get());
        } else {
            LOG.error("CourseWeek with id {} not found", CourseWeekId);
        }
    }

    public CourseWeekDto saveCourseWeek(CourseWeekDto CourseWeek) {
        return courseWeekToCourseWeekDTO(repository.save(courseWeekDTOToCourseWeek(CourseWeek)));
    }

    private CourseWeekDto courseWeekToCourseWeekDTO(CourseWeek entity) {
        CourseWeekDto dto = new CourseWeekDto(entity.getIdCourseWeek().toHexString(),entity.getNrOfWeekes());
        dto.setCourseMaterials(entity.getCourseMaterials().stream()
                .map(CourseMaterialService::courseMaterialToCourseMaterialDTO).collect(Collectors.toList()));
        dto.setLectures(entity.getLectures().stream()
                .map(LectureService::lectureToLectureDTO).collect(Collectors.toList()));
        return dto;
    }

    private CourseWeek courseWeekDTOToCourseWeek(CourseWeekDto dto) {
        CourseWeek entity = new CourseWeek(new ObjectId(dto.getIdCourseWeek()),dto.getNrOfWeekes());
        entity.setLectures(dto.getLectures().stream()
                .map(LectureService::lectureDTOToLecture).collect(Collectors.toList()));
        entity.setCourseMaterials(dto.getCourseMaterials().stream()
                .map(CourseMaterialService::courseMaterialDTOToCourseMaterial).collect(Collectors.toList()));
        return entity;
    }
}