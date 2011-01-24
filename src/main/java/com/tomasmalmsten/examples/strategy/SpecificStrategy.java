package com.tomasmalmsten.examples.strategy;

public class SpecificStrategy implements Strategy {

    SpecificStrategy() {}

    public void execute() {
        System.out.println("Specific Strategy!");
    }
}
