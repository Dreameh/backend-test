package dev.dreameh.backend.rest.converter;

import dev.dreameh.backend.rest.v1.api.dto.Project;
import java.util.List;
import java.util.stream.Collectors;

public final class ProjectConverter {

  private ProjectConverter() {}

  public static List<Project> toProjectList(
      final List<dev.dreameh.backend.domain.Project> projects) {
    return projects.stream().map(ProjectConverter::toProject).collect(Collectors.toList());
  }

  private static Project toProject(final dev.dreameh.backend.domain.Project project) {
    return new Project().title(project.getTitle()).text(project.getText());
  }
}
