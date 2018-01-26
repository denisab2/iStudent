package ro.ubb.istudent.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.CourseWeekDto;
import ro.ubb.istudent.service.CourseWeekService;
import ro.ubb.istudent.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;

@RequestMapping("/api")
@RestController
public class CourseWeekResource {

    private static final String COURSEWEEK_CONTROLLER_MAPPING = "/courseWeek";
    private static final Logger LOG = LoggerFactory.getLogger(CourseWeekResource.class);
    private final CourseWeekService service;
    private final String baseUrl;

    public CourseWeekResource(CourseWeekService service, @Value("${application.base-url}") String baseUrl) {
        this.service = service;
        this.baseUrl = baseUrl;
    }

    @GetMapping("/courseWeek/{courseWeekId}")
    public ResponseEntity getCourseWeek(@PathVariable("courseWeekId") String courseWeekId) {
        return ResponseUtil.wrapOrNotFound(service.findCourseWeekById(courseWeekId));
    }

    @PutMapping("/courseWeek/{courseWeekId}")
    public ResponseEntity<Void> updateCourseWeek(@PathVariable("courseWeekId") String courseWeekId,
                                                 @RequestBody CourseWeekDto courseWeek) {
        LOG.debug("Updating courseWeek with id: " + courseWeekId + " and new courseWeek value:" + courseWeek);
        service.updateCourseWeekById(courseWeekId, courseWeek);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(COURSEWEEK_CONTROLLER_MAPPING + "/{courseWeekId}")
    public ResponseEntity<Void> deleteCourseWeek(@PathVariable("courseWeekId") String courseWeekId) {
        LOG.debug("Deleting courseWeek with id: " + courseWeekId);
        service.deleteCourseWeekById(courseWeekId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(COURSEWEEK_CONTROLLER_MAPPING)
    public ResponseEntity createCourseWeek(@RequestBody CourseWeekDto courseWeek) throws URISyntaxException {
        LOG.debug("Creating courseWeek with value: " + courseWeek);
        CourseWeekDto savedCourseWeek = service.saveCourseWeek(courseWeek);
        return ResponseEntity.created(new URI(baseUrl + COURSEWEEK_CONTROLLER_MAPPING + "/" +
                savedCourseWeek.getIdCourseWeek())).build();
    }

}
