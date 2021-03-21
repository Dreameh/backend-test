package dev.dreameh.backend.service;

import dev.dreameh.backend.data.ProjectsDao;
import dev.dreameh.backend.domain.Project;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

  private Jdbi jdbi;

  private ProjectServiceImpl() {}

  public ProjectServiceImpl(final Jdbi jdbi) {
    this.jdbi = jdbi;
    jdbi.useExtension(ProjectsDao.class, ProjectsDao::createProjectsTable);
  }

  public List<Project> getProjects() {
    return jdbi.withExtension(ProjectsDao.class, ProjectsDao::getProjects);
  }
}
