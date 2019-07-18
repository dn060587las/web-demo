package org.demo.dao.impl;


import org.demo.dao.LocationDAO;
import org.demo.domains.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LocationDAOImpl implements LocationDAO {

    private JdbcTemplate template;

    @Autowired
    @Qualifier("template1")
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public boolean exists(String locationId) {
        return template.queryForObject("select count(*) from LOCATIONS where ID = ?",
                Boolean.class, locationId);
    }

    @Override
    public Location add(Location location) {
        int rows = template.update("insert into LOCATIONS(ID, NAME)\n"+
                "values(?, ?)", location.getId(), location.getName());
        if (rows == 1) {
            return location;
        }
        throw new RuntimeException("Something went wrong");
    }

    @Override
    public boolean delete(String location) {
        int rows = template.update(
                "delete from LOCATIONS where ID = ?", location);
        if (rows == 1) {
            return true;
        }
        throw new RuntimeException(String.format("Location %s not found", location));
    }
}
