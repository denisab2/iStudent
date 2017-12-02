package ro.ubb.istudent.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Assignment;
import ro.ubb.istudent.dto.AssignmentDto;
import ro.ubb.istudent.repository.AssingnmentRepository;

import java.util.Optional;

@Service
public class AssingnmentService {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingService.class);
    private final AssingnmentRepository repository;

    public AssingnmentService(AssingnmentRepository repository) {
        this.repository = repository;
    }

    public Optional<AssignmentDto> findGreetingById(String Id) {
        return repository.findAssignmentById(Id)
                .map(this::ssignmentToAssignmentDTO);
    }

    public void updateAssignmentWithId(String assignmentId, AssignmentDto request) {
        Optional<Assignment> optionalAssignment = repository.findAssignmentById(assignmentId);
        if (optionalAssignment.isPresent()) {
            Assignment assignment = optionalAssignment.get();
            assignment.setDescription(request.getDescription());
            assignment.setEndDate(request.getEndDate());
            repository.save(assignment);
        } else {
            LOG.error("Assignment with id {} not found", assignmentId);
        }
    }

    public void deleteAssignmentById(String assignmentId) {
        Optional<Assignment> optionalAssignment = repository.findAssignmentById(assignmentId);
        if (optionalAssignment.isPresent()) {
            repository.delete(optionalAssignment.get());
        } else {
            LOG.error("Assignment with id {} not found", assignmentId);
        }
    }

    public AssignmentDto createGreeting(AssignmentDto assignment) {
        return ssignmentToAssignmentDTO(repository.save(assignmentDTOToAssignment(assignment)));
    }

    private AssignmentDto ssignmentToAssignmentDTO(Assignment entity) {
        AssignmentDto dto = new AssignmentDto(entity.getDescription(),entity.getEndDate());
        dto.setIdAssignment(entity.getIdAssignment().toHexString());
        return dto;
    }

    private Assignment assignmentDTOToAssignment(AssignmentDto dto) {
        Assignment entity = new Assignment(dto.getDescription(),dto.getEndDate());
        entity.setIdAssignment(new ObjectId(dto.getIdAssignment()));
        return entity;
    }
}
