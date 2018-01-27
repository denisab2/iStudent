package ro.ubb.istudent.rest;

/**
 * Created by M. B. on 1/27/2018.
 */

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.domain.Project;
import ro.ubb.istudent.dto.ProjectDto;
import ro.ubb.istudent.dto.ProjectsDto;
import ro.ubb.istudent.service.evaluable.ProjectService;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ProjectResource {

    private static final String PROJECT_CONTROLLER_MAPPING = "/project";

    private static final Logger logger = LoggerFactory.getLogger(ProjectResource.class);

    @Autowired
    private ProjectService service;

    @Value("${application.base-url}")
    private String baseUrl;

    @PostMapping(PROJECT_CONTROLLER_MAPPING)
    public ResponseEntity createProject(@RequestBody ProjectDto projectDto) throws URISyntaxException {
        logger.trace("creating project={}", projectDto);
        Project project = service.save(projectDto.getContentSize(), projectDto.getContentQuality(), projectDto
                .getTopicStrength());
        return ResponseEntity.ok(ProjectDto.builder()
                .contentQuality(project.getContentQuality())
                .contentSize(project.getContentSize())
                .projectId(project.getProjectId()
                        .toString())
                .topicStrength(project.getTopicStrength())
                .build());
    }

    @GetMapping(PROJECT_CONTROLLER_MAPPING)
    public ResponseEntity getProjects() throws URISyntaxException {
        logger.info("getting projects");
        List<Project> projects = service.findAll();
        ProjectsDto projectsDto = ProjectsDto.builder()
                .projects(projects)
                .build();
        logger.info("result={}", projectsDto);
        return ResponseEntity.ok(projectsDto);
    }

    @DeleteMapping(PROJECT_CONTROLLER_MAPPING)
    public void deleteProject(@RequestParam("projectId") String projectId) throws URISyntaxException {
        logger.info("deleting project=", projectId);
        service.delete(projectId);
    }

}

