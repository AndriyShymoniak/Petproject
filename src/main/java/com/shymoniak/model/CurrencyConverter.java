package com.shymoniak.model;

import java.util.Map;

// TODO: 2021-08-27  Add auto-reload of currencies once in 3 hours

/**
 * Is used to work with different currencies
 */
public interface CurrencyConverter {
    Map<String, Double> getExchangeValues();
}
