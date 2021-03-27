package dev.dreameh.backend.rest.converter;

import dev.dreameh.backend.rest.v1.api.dto.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class ProjectConverter {

  private ProjectConverter() {}

  public static List<Project> toProjectList(
      final Iterable<dev.dreameh.backend.service.domain.Project> projects) {
    var dtoList = new ArrayList<Project>();
    projects.forEach(obj -> dtoList.add(toProject(obj)));
    return dtoList;
  }

  private static Project toProject(final dev.dreameh.backend.service.domain.Project project) {
    return new Project()
        .id(project.getId())
        .title(project.getTitle())
        .text(project.getText());
  }
}
