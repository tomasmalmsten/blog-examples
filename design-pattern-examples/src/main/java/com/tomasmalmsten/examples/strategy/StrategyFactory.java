package com.tomasmalmsten.examples.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
    public static final String DEFAULT_STRATEGY_KEY = "default";
    public static final String SPECIFIC_STRATEGY_KEY = "specific";

    private static StrategyFactory instance = new StrategyFactory();

    private Map<String, Strategy> strategies = new HashMap<String, Strategy>(2);

    private StrategyFactory() {
        strategies.put(DEFAULT_STRATEGY_KEY, new DefaultStrategy());
        strategies.put(SPECIFIC_STRATEGY_KEY, new SpecificStrategy());
    }

    public Strategy findStrategyForKey(String key) {
        return strategies.get(key);
    }

    public static StrategyFactory getInstance() {
        return instance;
    }
}
