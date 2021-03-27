package dev.dreameh.backend.data;

import dev.dreameh.backend.service.domain.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends MongoRepository<Project, Long> {
}
