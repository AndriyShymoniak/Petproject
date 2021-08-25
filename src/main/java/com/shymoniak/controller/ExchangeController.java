package com.shymoniak.controller;

import com.shymoniak.model.ExchangeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/convertCurrency")
    public ResponseEntity<Double> convertCurrency(@RequestParam String currencyFrom,
                                                  @RequestParam String currencyTo,
                                                  @RequestParam Double amount) {
        return new ResponseEntity<>(exchangeService.exchange(currencyFrom, currencyTo, amount), HttpStatus.OK);
    }
}
