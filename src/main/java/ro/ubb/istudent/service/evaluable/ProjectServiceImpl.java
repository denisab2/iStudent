package ro.ubb.istudent.service.evaluable;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.istudent.domain.Project;
import ro.ubb.istudent.repository.ProjectRepository;

import java.util.List;

/**
 * Created by Administrator on 26.01.2018.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        logger.trace("finding all projects");
        List<Project> projects = projectRepository.findAll();
        logger.trace("projects={}", projects);
        return projects;
    }

    @Override
    public Project save(Float contentSize, Float contentQuality, Float topicStrength) {
        logger.trace("creating project: contentSize={}, contentQuality={}, topicStrength={}", contentSize,
                     contentQuality, topicStrength);
        Project project = Project.builder()
                                 .contentQuality(contentQuality)
                                 .contentSize(contentSize)
                                 .topicStrength(topicStrength)
                                 .build();
        project = projectRepository.save(project);
        logger.trace("created project={}", project);
        return project;
    }

    @Override
    public void delete(String projectId) {
        logger.info("deleting project={}", projectId);
        projectRepository.delete(new ObjectId(projectId));
    }
}
