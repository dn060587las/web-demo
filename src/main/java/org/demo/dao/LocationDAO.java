package org.demo.dao;

import org.demo.domains.Location;

public interface LocationDAO {

    boolean exists(String locationId);

    Location add(Location location);

    boolean delete(String location);
}
