package ro.ubb.istudent.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.ExamDto;
import ro.ubb.istudent.service.ExamService;
import ro.ubb.istudent.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;

@RequestMapping("/api")
@RestController
public class ExamResource {

    private static final String EXAM_CONTROLLER_MAPPING = "/exam";
    private static final Logger LOG = LoggerFactory.getLogger(ExamResource.class);
    private final ExamService service;
    private final String baseUrl;

    public ExamResource(ExamService service, @Value("${application.base-url}") String baseUrl) {
        this.service = service;
        this.baseUrl = baseUrl;
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity getExam(@PathVariable("examId") String examId) {
        return ResponseUtil.wrapOrNotFound(service.findExamById(examId));
    }

    @PutMapping("/exam/{examId}")
    public ResponseEntity<Void> updateExam(@PathVariable("examId") String examId, @RequestBody ExamDto exam) {
        LOG.debug("Updating exam with id: " + examId + " and new exam value:" + exam);
        service.updateExamById(examId, exam);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(EXAM_CONTROLLER_MAPPING + "/{examId}")
    public ResponseEntity<Void> deleteExam(@PathVariable("examId") String examId) {
        LOG.debug("Deleting exam with id: " + examId);
        service.deleteExamById(examId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(EXAM_CONTROLLER_MAPPING)
    public ResponseEntity createExam(@RequestBody ExamDto exam) throws URISyntaxException {
        LOG.debug("Creating exam with value: " + exam);
        ExamDto savedExam = service.saveExam(exam);
        return ResponseEntity.created(new URI(baseUrl + EXAM_CONTROLLER_MAPPING + "/" +
                savedExam.getExamId())).build();
    }

}
