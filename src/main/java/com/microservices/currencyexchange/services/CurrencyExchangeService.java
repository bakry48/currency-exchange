package com.microservices.currencyexchange.services;

import com.microservices.currencyexchange.models.entity.CurrencyExchange;
import com.microservices.currencyexchange.repository.CurrencyExchangeRepo;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
    private final CurrencyExchangeRepo currencyExchangeRepo;
    public CurrencyExchangeService(CurrencyExchangeRepo currencyExchangeRepo) {
        this.currencyExchangeRepo = currencyExchangeRepo;
    }

    public CurrencyExchange findCurrwncyByFromAndTo(String from , String to){
     CurrencyExchange currencyExchange= currencyExchangeRepo.findByFromAndTo(from, to);
     if (currencyExchange==null)
         throw new RuntimeException("the Currency Exchange from"+ from + " to " + to + "not found");
     return currencyExchange;
    }
}
