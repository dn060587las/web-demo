package org.demo.components;

import org.springframework.stereotype.Component;

@Component
public class NumberAdder {

    public int add(int a, int b) {
        return a + b;
    }
}
