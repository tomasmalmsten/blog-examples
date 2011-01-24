package com.tomasmalmsten.examples.strategy;

public class DefaultStrategy implements Strategy {

    DefaultStrategy() {}

    public void execute() {
        System.out.println("Default Strategy!");
    }
}
