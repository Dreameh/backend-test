package dev.dreameh.backend.domain;

import java.util.Objects;
import java.util.StringJoiner;

public final class Project {

  private final String title;
  private final String text;

  public Project(final String title, final String text) {
    this.title = title;
    this.text = text;
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
