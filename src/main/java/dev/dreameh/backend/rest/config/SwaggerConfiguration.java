package dev.dreameh.backend.rest.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceTransformerChain;
import org.springframework.web.servlet.resource.TransformedResource;
import org.springframework.web.servlet.resource.WebJarsResourceResolver;

@Configuration
public class SwaggerConfiguration implements WebMvcConfigurer {

  private static final String SWAGGER_PETSHOP_URL = "https://petstore.swagger.io/v2/swagger.json";

  private final String openapiUri;

  public SwaggerConfiguration(@Value("${springdoc.swagger-ui.url}") final String openapiUri) {
    this.openapiUri = openapiUri;
  }

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    if (!openapiUri.isEmpty()) {
      registry
          .addResourceHandler("/swagger-ui/index.html")
          .addResourceLocations("classpath:/META-INF/resources/webjars/")
          .resourceChain(false)
          .addResolver(new WebJarsResourceResolver())
          .addResolver(new PathResourceResolver())
          .addTransformer(this::transformSwaggerIndexPage);
    }
  }

  public Resource transformSwaggerIndexPage(
      final HttpServletRequest request,
      final Resource resource,
      final ResourceTransformerChain transformerChain) {

    try (var buffer = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
      final String content = buffer.lines().collect(Collectors.joining("\n"));
      final String changedContent = content.replace(SWAGGER_PETSHOP_URL, openapiUri);

      return new TransformedResource(resource, changedContent.getBytes());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
