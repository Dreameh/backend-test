package dev.dreameh.backend.rest.converter;

import dev.dreameh.backend.service.domain.Project;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectConverterTest {

    @Test
    public void testSuccessUseToProjectList() {
     var projects = List.of(new Project(1L, "Hello", "World"));
     var expectedList = List.of(
         new dev.dreameh.backend.rest.v1.api.dto.Project()
             .id(1L)
             .title("Hello")
             .text("World"));
     assertEquals(expectedList, ProjectConverter.toProjectList(projects));
    }
}
