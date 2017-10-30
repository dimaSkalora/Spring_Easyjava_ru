package spring_data_access.spring_jdbc.head_02.easyjava.spring.data.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Spring programmatic context configuration.
 */
@Configuration
public class ContextConfiguration {
    /**
     * Create HSQLDB data source.
     * @return hsql database bean.
     */
    @Bean
    public DataSource hsqlDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .setScriptEncoding("UTF-8")
                .addScript("schema.sql")
                .addScript("hsql-data.sql")
                .build();
    }

    /**
     * Create jdbc template for HSQLDB.
     * @return hsql database jdbc template.
     */
    @Bean
    public JdbcTemplate hsqlTemplate() {
        return new JdbcTemplate(hsqlDataSource());
    }
}
