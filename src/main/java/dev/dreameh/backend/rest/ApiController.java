package dev.dreameh.backend.rest;

import dev.dreameh.backend.rest.converter.ProjectConverter;
import dev.dreameh.backend.rest.v1.api.ProjectsApi;
import dev.dreameh.backend.rest.v1.api.dto.Project;
import dev.dreameh.backend.service.ProjectService;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements ProjectsApi {

  private ProjectService service;

  public ApiController(final ProjectService projectService) {
    this.service = projectService;
  }

  @Override
  public ResponseEntity<List<Project>> getProjects() {
    List<Project> projects = ProjectConverter.toProjectList(service.getProjects());
    return ResponseEntity.ok(projects);
  }
}
