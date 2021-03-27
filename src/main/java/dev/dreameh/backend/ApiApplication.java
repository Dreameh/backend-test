package dev.dreameh.backend;

import dev.dreameh.backend.data.ProjectsRepository;
import dev.dreameh.backend.service.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer implements CommandLineRunner {
  
  @Autowired
  private ProjectsRepository repository;

  public static void main(String... args) {
    SpringApplication.run(ApiApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
    return builder.sources(ApiApplication.class);
  }

  @Override
  public void run(String... args) {
    try {
      // Clearing contents
      repository.deleteAll();

      // Adding initial content
      var project = new Project(1L, "API", "Uses MongoDB, Spring Boot, OpenAPI & JUnit");
      repository.save(project);
      project = new Project(2L, "Frontend", "Uses React, Express, Jest & Bootstrap for React");
      repository.save(project);

      // Try to fetch those
      var test = repository.findAll();
      test.forEach(obj -> System.out.println(obj.toString()));
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }
}
