package com.realtime.stock.quotes.realTimeStockQuotes.controller;


import com.realtime.stock.quotes.realTimeStockQuotes.model.StockQuote;
import com.realtime.stock.quotes.realTimeStockQuotes.service.StockQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/stock-quotes")
public class StockQuoteController {

    private final StockQuoteService stockQuoteService;

    @Autowired
    public StockQuoteController(StockQuoteService stockQuoteService) {
        this.stockQuoteService = stockQuoteService;
    }

    @GetMapping("/quote/{symbol}")
    public StockQuote getStockQuote(@PathVariable String symbol) {
        System.out.println("Received request for symbol: " + symbol);
        return stockQuoteService.getQuoteBySymbol(symbol, "M4RLAI8DVMJQHSS5"); // API key here
    }

    @GetMapping("/batch-quotes")
    public ResponseEntity<List<StockQuote>> getBatchQuotesBySymbols(@RequestParam List<String> symbols) {
        List<StockQuote> stockQuotes = stockQuoteService.getBatchQuotesBySymbols(symbols.toArray(new String[0]), "M4RLAI8DVMJQHSS5");
        return ResponseEntity.ok(stockQuotes);
    }
}
