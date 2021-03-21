package dev.dreameh.backend.data;

import dev.dreameh.backend.domain.Project;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;

public interface ProjectsDao {

  @Transaction
  @SqlUpdate(
      "CREATE TABLE IF NOT EXISTS projects(id BIGINT NOT NULL PRIMARY KEY, title VARCHAR(48), text VARCHAR(1000)")
  void createProjectsTable();

  @SqlQuery("SELECT * FROM projects")
  @RegisterBeanMapper(Project.class)
  List<Project> getProjects();
}