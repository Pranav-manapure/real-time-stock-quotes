package com.realtime.stock.quotes.realTimeStockQuotes.repository;

import com.realtime.stock.quotes.realTimeStockQuotes.model.StockQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockQuoteJpaRepository extends JpaRepository<StockQuote, Long> {


    // Check if a stock quote already exists for the given symbol and timestamp
    boolean existsBySymbolAndTimestamp(String symbol, String timestamp);

}
