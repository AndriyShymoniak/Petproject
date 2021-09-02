package com.shymoniak.service.impl;

import com.shymoniak.model.CurrencyConverter;
import com.shymoniak.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    private final CurrencyConverter converter;

    @Autowired
    public ExchangeServiceImpl(CurrencyConverter converter) {
        this.converter = converter;
    }

    @Override
    public Double exchange(String from, String to, Double amount) {
        Map<String, Double> currencyValues = converter.getExchangeValues();
        return amount * currencyValues.get(to) / currencyValues.get(from);
    }
}
