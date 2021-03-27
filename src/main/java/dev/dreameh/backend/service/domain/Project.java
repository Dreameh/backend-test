package dev.dreameh.backend.service.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.StringJoiner;

@Document(collection = "projects")
public final class Project {

  @Id
  private Long id;
  private String title;
  private String text;

  public Project(final Long id, final String title, final String text) {
    this.id = id;
    this.title = title;
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Project.class.getSimpleName() + "[", "]")
        .add("title='" + title + "'")
        .add("text='" + text + "'")
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Project project = (Project) o;
    return Objects.equals(title, project.title) && Objects.equals(text, project.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, text);
  }
}
