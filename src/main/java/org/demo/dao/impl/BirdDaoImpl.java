package org.demo.dao.impl;

import org.demo.dao.BirdDAO;
import org.demo.dao.LocationDAO;
import org.demo.domains.Bird;
import org.demo.domains.Location;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BirdDaoImpl implements BirdDAO
{
    @Autowired
    @Qualifier("template1")
    private JdbcTemplate template;

    @Autowired
    private LocationDAO locationDAO;

    @Override
    public Bird add(Bird bird) {
        Location location = bird.getLocation();
        if (location != null
            && !locationDAO.exists(location.getId())) {
            locationDAO.add(bird.getLocation());
        }
        template.update("INSERT INTO BIRDS(ID, NAME, SIZE, LOCATION_ID)\n"+
                "values (?, ? , ? , ?)", bird.getId(), bird.getName(),
                bird.getSize(), location == null ? null : location.getId());
        return bird;
    }

    @Override
    public boolean delete(String id) {
        int rows = template.update("delete from BIRDS where ID = ?", id);
        if (rows == 1) {
            return true;
        }
        throw new RuntimeException(
                String.format("Bird with id %s not exists", id)
        );
    }

    @Override
    public List<Bird> findByLocation(String location) {
        return template.query("select  b.ID, b.NAME, b.SIZE, b.LOCATION_ID, l.NAME as LOCATION_NAME\n" +
                "from BIRDS b, LOCATIONS l\n" +
                "where l.NAME like '%' + ? + '%'\n" +
                "and l.ID = b.LOCATION_ID;", (resultSet, i) -> {
            Bird b = new Bird();
            b.setId(resultSet.getString("ID"));
            b.setName(resultSet.getString("NAME"));
            b.setSize(resultSet.getDouble("SIZE"));
            Location loc = new Location();
            loc.setId(resultSet.getString("LOCATION_ID"));
            loc.setName(resultSet.getString("LOCATION_NAME"));
            b.setLocation(loc);
            return b;
        }, location);
    }

    @Override
    public Bird update(Bird bird) {
        return null;
    }
}
