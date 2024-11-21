package com.realtime.stock.quotes.realTimeStockQuotes.service;

import com.realtime.stock.quotes.realTimeStockQuotes.model.StockQuote;
import com.realtime.stock.quotes.realTimeStockQuotes.repository.StockQuoteRepository;
import com.realtime.stock.quotes.realTimeStockQuotes.repository.StockQuoteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockQuoteService {

    private final StockQuoteRepository stockQuoteRepository;
    private final StockQuoteJpaRepository stockQuoteJpaRepository;

    @Autowired
    public StockQuoteService(StockQuoteRepository stockQuoteRepository, StockQuoteJpaRepository stockQuoteJpaRepository) {
        this.stockQuoteRepository = stockQuoteRepository;
        this.stockQuoteJpaRepository = stockQuoteJpaRepository;
    }

    /**
     * Fetch a single stock quote by symbol and save it to the database.
     *
     * @param symbol the stock symbol
     * @param apiKey the API key for Alpha Vantage
     * @return the fetched stock quote
     */
    public StockQuote getQuoteBySymbol(String symbol, String apiKey) {
        StockQuote stockQuote = stockQuoteRepository.getStockQuote(symbol, apiKey);

        // Check for duplicate before saving
        if (stockQuote != null) {
            boolean exists = stockQuoteJpaRepository.existsBySymbolAndTimestamp(stockQuote.getSymbol(), stockQuote.getTimestamp());
            if (!exists) {
                stockQuoteJpaRepository.save(stockQuote);
            } else {
                System.out.println("Duplicate entry detected: Symbol=" + stockQuote.getSymbol() + ", Timestamp=" + stockQuote.getTimestamp());
            }
        }
        return stockQuote;
    }

    /**
     * Fetch multiple stock quotes for a batch of symbols and save them to the database.
     *
     * @param symbols array of stock symbols
     * @param apiKey  the API key for Alpha Vantage
     * @return a list of fetched stock quotes
     */
    public List<StockQuote> getBatchQuotesBySymbols(String[] symbols, String apiKey) {
        List<StockQuote> savedQuotes = new ArrayList<>();

        for (String symbol : symbols) {
            // Fetch stock quote for the current symbol
            StockQuote stockQuote = stockQuoteRepository.getStockQuote(symbol, apiKey);

            // Check for duplicate before saving
            if (stockQuote != null) {
                boolean exists = stockQuoteJpaRepository.existsBySymbolAndTimestamp(stockQuote.getSymbol(), stockQuote.getTimestamp());
                if (!exists) {
                    stockQuoteJpaRepository.save(stockQuote);
                    savedQuotes.add(stockQuote); // Add successfully saved quotes to the list
                } else {
                    System.out.println("Duplicate entry detected: Symbol=" + stockQuote.getSymbol() + ", Timestamp=" + stockQuote.getTimestamp());
                }
            }
        }

        return savedQuotes;
    }
}
