package dev.dreameh.backend.service;

import dev.dreameh.backend.data.ProjectsDao;
import dev.dreameh.backend.domain.Project;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Component;

@Component
public class ProjectServiceImpl implements ProjectService {


  private ProjectsDao dao;

  private ProjectServiceImpl() {}

  public ProjectServiceImpl(final Jdbi jdbi) {
    this.dao = jdbi.onDemand(ProjectsDao.class);
  }

  public List<Project> getProjects() {
    return dao.getProjects();
  }
}
