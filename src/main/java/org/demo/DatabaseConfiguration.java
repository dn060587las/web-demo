package org.demo;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    
    @Bean
    public DataSource createDatasource() {        
        DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
        dataSource.setDriverClassName("org.h2.Driver"); 
        dataSource.setUrl("jdbc:h2:~/mydbInHomeDir;AUTO_SERVER=TRUE");         
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
