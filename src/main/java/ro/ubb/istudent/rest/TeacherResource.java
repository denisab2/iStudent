package ro.ubb.istudent.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.TeacherDto;
import ro.ubb.istudent.service.TeacherService;
import ro.ubb.istudent.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;

@RequestMapping("/api")
@RestController
public class TeacherResource {

    private static final String TEACHER_CONTROLLER_MAPPING = "/teacher";
    private static final Logger LOG = LoggerFactory.getLogger(TeacherResource.class);
    private final TeacherService service;
    private final String baseUrl;

    public TeacherResource(TeacherService service, @Value("${application.base-url}") String baseUrl) {
        this.service = service;
        this.baseUrl = baseUrl;
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity getTeacher(@PathVariable("teacherId") String teacherId) {
        return ResponseUtil.wrapOrNotFound(service.findTeacherById(teacherId));
    }

    @PutMapping("/teacher/{teacherId}")
    public ResponseEntity<Void> updateTeacher(@PathVariable("teacherId") String teacherId,
                                              @RequestBody TeacherDto teacher) {
        LOG.debug("Updating teacher with id: " + teacherId + " and new teacher value:" + teacher);
        service.updateTeacherById(teacherId, teacher);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(TEACHER_CONTROLLER_MAPPING + "/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("teacherId") String teacherId) {
        LOG.debug("Deleting teacher with id: " + teacherId);
        service.deleteTeacherById(teacherId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(TEACHER_CONTROLLER_MAPPING)
    public ResponseEntity createTeacher(@RequestBody TeacherDto teacher) throws URISyntaxException {
        LOG.debug("Creating teacher with value: " + teacher);
        TeacherDto savedTeacher = service.saveTeacher(teacher);
        return ResponseEntity.created(new URI(baseUrl + TEACHER_CONTROLLER_MAPPING + "/" +
                savedTeacher.getIdTeacher())).build();
    }

}
