package dev.dreameh.backend.rest;

import dev.dreameh.backend.rest.converter.ProjectConverter;
import dev.dreameh.backend.rest.v1.api.ProjectsApi;
import dev.dreameh.backend.rest.v1.api.dto.Project;
import dev.dreameh.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ApiController implements ProjectsApi {

  @Autowired
  private ProjectService service;

  @Async
  @Override
  public ResponseEntity<List<Project>> getProjects() {
    List<Project> projects = ProjectConverter.toProjectList(service.getProjects());
    if(projects == null || projects.isEmpty()) {
      throw new IllegalStateException("This cannot be the case");
    }

    return new ResponseEntity<>(projects, HttpStatus.OK);
  }
}
