package dev.dreameh.backend.rest.config;

import javax.sql.DataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbiConfiguration {

  @Bean
  public Jdbi jdbi(final DataSource dataSource) {
    return Jdbi.create(dataSource)
        .installPlugin(new PostgresPlugin())
        .installPlugin(new SqlObjectPlugin());
  }
}
