package com.microservices.currencyexchange.controller;

import com.microservices.currencyexchange.models.entity.CurrencyExchange;
import com.microservices.currencyexchange.services.CurrencyExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyController {
    private final Environment environment;
    private final CurrencyExchangeService currencyExchangeService;
    public CurrencyController(Environment environment , CurrencyExchangeService currencyExchangeService) {
        this.environment = environment;
        this.currencyExchangeService= currencyExchangeService;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
     @PathVariable String from,
     @PathVariable String to
    ){
        CurrencyExchange currencyExchange = new CurrencyExchange(1001L, from, to, BigDecimal.valueOf(50));
        String serverPort =environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(serverPort);
        return currencyExchange;
    }
    @GetMapping("/getcurrency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(
            @PathVariable String from,
            @PathVariable String to
    ){
        CurrencyExchange currencyExchange = currencyExchangeService.findCurrwncyByFromAndTo(from , to);
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}