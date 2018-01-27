package ro.ubb.istudent.rest;

/**
 * Created by M. B. on 1/25/2018.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.domain.Evaluable;
import ro.ubb.istudent.domain.Project;
import ro.ubb.istudent.dto.EvaluablesDto;
import ro.ubb.istudent.dto.ProjectDto;
import ro.ubb.istudent.dto.ProjectsDto;
import ro.ubb.istudent.service.EvaluationServiceFacade;
import ro.ubb.istudent.service.evaluable.ProjectService;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

@RequestMapping("/api")
@RestController
public class EvaluableResource {

    private static final String PROJECT_CONTROLLER_MAPPING = "/evaluable";

    private static final Logger logger = LoggerFactory.getLogger(EvaluableResource.class);

    @Autowired
    private EvaluationServiceFacade service;

    @Value("${application.base-url}")
    private String baseUrl;

    @GetMapping(PROJECT_CONTROLLER_MAPPING)
    public ResponseEntity getEvaluables() throws URISyntaxException {
        logger.info("getting evaluables");
        List<Evaluable> evaluables = service.findAll();
        EvaluablesDto evaluablesDto = EvaluablesDto.builder()
                .data(evaluables)
                .build();
        logger.info("result={}", evaluablesDto);
        return ResponseEntity.ok(evaluablesDto);
    }

    @GetMapping(PROJECT_CONTROLLER_MAPPING + "/grade")
    public ResponseEntity evaluate() throws URISyntaxException {
        Random random = new Random();
        Evaluable next = service.findAll()
                .stream()
                .sorted((e1, e2) -> random.nextInt())
                .findFirst()
                .orElse(null);
        if (next == null) {
            return ResponseEntity.noContent()
                    .build();
        } else {
            logger.info("grading evaluable={}", next);
            logger.info("result: grade{}, passed={}", next.evaluate(), next.passed());
            return ResponseEntity.ok(String.format("{ \"grade\" : %f, \"passed\" : %b }", next.evaluate(), next
                    .passed()));
        }
    }

}

