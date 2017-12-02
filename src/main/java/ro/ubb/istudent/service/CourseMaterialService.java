package ro.ubb.istudent.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.CourseMaterial;
import ro.ubb.istudent.dto.CourseMaterialDto;
import ro.ubb.istudent.repository.CourseMaterialRepository;

import java.util.Optional;

@Service
public class CourseMaterialService {

    private static final Logger LOG = LoggerFactory.getLogger(CourseMaterialService.class);
    private final CourseMaterialRepository repository;

    public CourseMaterialService(CourseMaterialRepository repository) {
        this.repository = repository;
    }

    public Optional<CourseMaterialDto> findCourseMaterialById(String CourseMaterialId) {
        return repository.findCourseMaterialById(CourseMaterialId)
                .map(CourseMaterialService::CourseMaterialToCourseMaterialDTO);
    }

    public void updateCourseMaterialWithId(String CourseMaterialId, CourseMaterialDto request) {
        Optional<CourseMaterial> optionalCourseMaterial = repository.findCourseMaterialById(CourseMaterialId);
        if (optionalCourseMaterial.isPresent()) {
            CourseMaterial courseMaterial = optionalCourseMaterial.get();
            courseMaterial.setDescription(request.getDescription());
            courseMaterial.setFilePath(request.getFilePath());
            repository.save(courseMaterial);
        } else {
            LOG.error("CourseMaterial with id {} not found", CourseMaterialId);
        }
    }

    public void deleteCourseMaterialById(String CourseMaterialId) {
        Optional<CourseMaterial> optionalCourseMaterial = repository.findCourseMaterialById(CourseMaterialId);
        if (optionalCourseMaterial.isPresent()) {
            repository.delete(optionalCourseMaterial.get());
        } else {
            LOG.error("CourseMaterial with id {} not found", CourseMaterialId);
        }
    }

    public CourseMaterialDto createCourseMaterial(CourseMaterialDto CourseMaterial) {
        return CourseMaterialToCourseMaterialDTO(repository.save(CourseMaterialDTOToCourseMaterial(CourseMaterial)));
    }

    public static CourseMaterialDto CourseMaterialToCourseMaterialDTO(CourseMaterial entity) {
        CourseMaterialDto dto = new CourseMaterialDto(entity.getMaterialsId().toHexString()
                ,entity.getDescription(),entity.getFilePath());
        return dto;
    }

    public static CourseMaterial CourseMaterialDTOToCourseMaterial(CourseMaterialDto dto) {
        CourseMaterial entity = new CourseMaterial(dto.getMaterialsId(),dto.getDescription(),dto.getFilePath());
        return entity;
    }
}
