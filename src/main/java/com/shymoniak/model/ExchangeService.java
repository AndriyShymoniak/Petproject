package com.shymoniak.model;

/**
 * Is used to convert values to different currencies
 */
public interface ExchangeService {
    Double exchange(String from, String to, Double amount);
}
