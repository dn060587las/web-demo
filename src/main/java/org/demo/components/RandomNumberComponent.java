package org.demo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class RandomNumberComponent {

    private final DataStore ds;
    
    @Autowired
    private JdbcTemplate dds ;

    @PostConstruct
    public void init() {
        System.out.println("11111");
        dds.execute("select * from test");
        System.out.println("222");
    }
    
    @Autowired
    public RandomNumberComponent(DataStore ds) {
        this.ds = ds;
    }

    public int getRandom(int seed) {
        System.out.println("Data from datastore " + ds.getDataFromStorage());
        Random r = new Random(seed);
        return r.nextInt();
    }
}
