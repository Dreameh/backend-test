package dev.dreameh.backend.rest.config;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbiConfiguration {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource driverManagerDataSource() {
    return new DriverManagerDataSource();
  }

  @Bean
  public DataSourceTransactionManager dataSourceTransactionManager(final DataSource dataSource) {
    var dataSourceTransactionManager = new DataSourceTransactionManager();
    dataSourceTransactionManager.setDataSource(dataSource);
    return dataSourceTransactionManager;
  }

  @Bean
  public Jdbi jdbi(final DataSource dataSource) {
    return Jdbi.create(dataSource)
        .installPlugin(new PostgresPlugin())
        .installPlugin(new SqlObjectPlugin());
  }
}
