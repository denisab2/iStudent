package ro.ubb.istudent.rest;

/**
 * Created by M. B. on 1/27/2018.
 */

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.net.URI;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.domain.Project;
import ro.ubb.istudent.dto.GreetingDto;
import ro.ubb.istudent.dto.ProjectDto;
import ro.ubb.istudent.service.GreetingService;
import ro.ubb.istudent.service.evaluable.ProjectService;

import java.net.URISyntaxException;

@RequestMapping("/api")
@RestController
public class ProjectResource {

    private static final String PROJECT_CONTROLLER_MAPPING = "/project";

    private static final Logger logger = LoggerFactory.getLogger(ProjectResource.class);

    private final ProjectService service;
    private final String baseUrl;

    public ProjectResource(ProjectService service, @Value("${application.base-url}") String baseUrl) {
        this.service = service;
        this.baseUrl = baseUrl;
    }

    @PostMapping(PROJECT_CONTROLLER_MAPPING)
    public ResponseEntity createProject(@RequestBody ProjectDto projectDto) throws URISyntaxException {
        logger.trace("creating project={}", projectDto);
        Project project = service.create(projectDto.getContentSize(), projectDto.getContentQuality(), projectDto
                .getTopicStrength());
        return ResponseEntity.created(new URI(baseUrl + PROJECT_CONTROLLER_MAPPING + "/" + project.getProjectId()))
                .build();
    }

}

