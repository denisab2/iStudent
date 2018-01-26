package ro.ubb.istudent.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.AssignmentDto;
import ro.ubb.istudent.service.AssignmentService;
import ro.ubb.istudent.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;

@RequestMapping("/api")
@RestController
public class AssignmentResource {

    private static final String ASSIGNMENT_CONTROLLER_MAPPING = "/assignment";
    private static final Logger LOG = LoggerFactory.getLogger(AssignmentResource.class);
    private final AssignmentService service;
    private final String baseUrl;

    public AssignmentResource(AssignmentService service, @Value("${application.base-url}") String baseUrl) {
        this.service = service;
        this.baseUrl = baseUrl;
    }

    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity getAssignment(@PathVariable("assignmentId") String assignmentId) {
        return ResponseUtil.wrapOrNotFound(service.findAssignmentById(assignmentId));
    }

    @PutMapping("/assignment/{assignmentId}")
    public ResponseEntity<Void> updateAssignment(@PathVariable("assignmentId") String assignmentId,
                                                 @RequestBody AssignmentDto assignment) {
        LOG.debug("Updating assignment with id: " + assignmentId + " and new assignment value:" + assignment);
        service.updateAssignmentById(assignmentId, assignment);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(ASSIGNMENT_CONTROLLER_MAPPING + "/{assignmentId}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable("assignmentId") String assignmentId) {
        LOG.debug("Deleting assignment with id: " + assignmentId);
        service.deleteAssignmentById(assignmentId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(ASSIGNMENT_CONTROLLER_MAPPING)
    public ResponseEntity createAssignment(@RequestBody AssignmentDto assignment) throws URISyntaxException {
        LOG.debug("Creating assignment with value: " + assignment);
        AssignmentDto savedAssignment = service.saveAssignment(assignment);
        return ResponseEntity.created(new URI(baseUrl + ASSIGNMENT_CONTROLLER_MAPPING + "/" +
                savedAssignment.getIdAssignment())).build();
    }

}
