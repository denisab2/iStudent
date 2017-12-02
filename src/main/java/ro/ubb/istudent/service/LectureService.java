package ro.ubb.istudent.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Lecture;
import ro.ubb.istudent.dto.LectureDto;
import ro.ubb.istudent.repository.LectureRepository;

import java.util.Optional;

@Service
public class LectureService {

    private static final Logger LOG = LoggerFactory.getLogger(LectureService.class);
    private final LectureRepository repository;

    public LectureService(LectureRepository repository) {
        this.repository = repository;
    }

    public Optional<LectureDto> findLectureById(String LectureId) {
        return repository.findLectureById(LectureId)
                .map(LectureService::LectureToLectureDTO);
    }

    public void updateLectureWithId(String LectureId, LectureDto request) {
        Optional<Lecture> optionalLecture = repository.findLectureById(LectureId);
        if (optionalLecture.isPresent()) {
            Lecture lecture = optionalLecture.get();
            lecture.setDescription(request.getDescription());
            lecture.setFilePath(request.getFilePath());
            repository.save(lecture);
        } else {
            LOG.error("Lecture with id {} not found", LectureId);
        }
    }

    public void deleteLectureById(String LectureId) {
        Optional<Lecture> optionalLecture = repository.findLectureById(LectureId);
        if (optionalLecture.isPresent()) {
            repository.delete(optionalLecture.get());
        } else {
            LOG.error("Lecture with id {} not found", LectureId);
        }
    }

    public LectureDto createLecture(LectureDto Lecture) {
        return LectureToLectureDTO(repository.save(LectureDTOToLecture(Lecture)));
    }

    public static LectureDto LectureToLectureDTO(Lecture entity) {
        LectureDto dto = new LectureDto(entity.getLectureId().toHexString(),entity.getDescription(),
                entity.getFilePath());
        return dto;
    }

    public static Lecture LectureDTOToLecture(LectureDto dto) {
        Lecture entity = new Lecture(new ObjectId(dto.getLectureId()),dto.getDescription(),dto.getFilePath());
        return entity;
    }
}
