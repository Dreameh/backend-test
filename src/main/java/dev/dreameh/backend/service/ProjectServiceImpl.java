package dev.dreameh.backend.service;

import dev.dreameh.backend.data.ProjectsRepository;
import dev.dreameh.backend.service.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

  @Autowired
  private ProjectsRepository repository;

  private ProjectServiceImpl() {}

  public List<Project> getProjects() {
    return repository.findAll();
  }
}
