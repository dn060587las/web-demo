package org.demo.dao;

import org.demo.domains.Bird;

import java.util.List;

public interface BirdDAO {

    Bird add(Bird bird);

    boolean delete(String id);

    List<Bird> findByLocation(String location);

    Bird update(Bird bird);
}
