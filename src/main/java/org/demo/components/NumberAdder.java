package org.demo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberAdder {

    private final RandomNumberComponent randomComponent;

    private final DataStore ds;

    @Autowired
    public NumberAdder(RandomNumberComponent randomComponent,
                       DataStore ds) {
        this.randomComponent = randomComponent;
        this.ds = ds;
    }

    public int add(int a, int b) {
        ds.addDataToStorage(a + " " + b);
        return a + b + randomComponent.getRandom(b);
    }
}
