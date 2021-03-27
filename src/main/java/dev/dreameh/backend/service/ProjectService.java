package dev.dreameh.backend.service;

import dev.dreameh.backend.service.domain.Project;

public interface ProjectService {

  public Iterable<Project> getProjects();
}
