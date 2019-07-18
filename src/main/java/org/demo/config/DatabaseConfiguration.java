package org.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author alitvinov
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Bean(name = "databaseFirst")
    public DataSource createDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/mydbInHomeDir;AUTO_SERVER=TRUE");
        return dataSource;
    }

    @Bean(name = "databaseSecond")
    public DataSource createDatasource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/mydbInHomeDir2;AUTO_SERVER=TRUE");
        return dataSource;
    }
    
    @Bean(name = "template1")
    public JdbcTemplate jdbcTemplate(@Qualifier("databaseFirst")
                                                 DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "template2")
    public JdbcTemplate jdbcTemplate2(@Qualifier("databaseSecond")
                                             DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
