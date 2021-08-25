package com.shymoniak.model;

import java.util.Map;

public interface CurrencyConverter {
    Map<String, Double> getExchangeValues();
}
