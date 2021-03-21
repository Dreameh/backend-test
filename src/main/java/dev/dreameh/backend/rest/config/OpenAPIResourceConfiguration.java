package dev.dreameh.backend.rest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OpenAPIResourceConfiguration implements WebMvcConfigurer {

  private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/openapi/**").addResourceLocations("classpath:/openapi/");
  }
}
