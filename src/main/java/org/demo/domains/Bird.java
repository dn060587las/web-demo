package org.demo.domains;

import lombok.Data;

import java.util.List;

@Data
public class Bird {

    private String id;

    private String name;

    private Double size;

    private Location location;
}
