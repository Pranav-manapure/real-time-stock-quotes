package com.realtime.stock.quotes.realTimeStockQuotes.repository;

import com.realtime.stock.quotes.realTimeStockQuotes.model.StockQuote;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StockQuoteRepository {

    private final String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol={symbol}&outputsize=full&apikey={apikey}";

    public StockQuote getStockQuote(String symbol, String apiKey) {
        RestTemplate restTemplate = new RestTemplate();

        // Create a map to hold the URL parameters
        Map<String, String> params = new HashMap<>();
        params.put("symbol", symbol);
        params.put("apikey", apiKey);

        // Fetch the JSON response as a map
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<Map<String, Object>>() {}, params);

        Map<String, Object> responseBody = response.getBody();

//        System.out.println(responseBody);

        // Extract the relevant data
        Map<String, Object> timeSeries = (Map<String, Object>) responseBody.get("Time Series (Daily)");
        if (timeSeries != null) {
            String latestDate = (String) timeSeries.keySet().toArray()[0];  // Get the latest date
            Map<String, String> latestData = (Map<String, String>) timeSeries.get(latestDate);

            // Create StockQuote from the latest data
            StockQuote stockQuote = new StockQuote();
            stockQuote.setSymbol(symbol);
            stockQuote.setTimestamp(latestDate);
            stockQuote.setOpen(latestData.get("1. open"));
            stockQuote.setHigh(latestData.get("2. high"));
            stockQuote.setLow(latestData.get("3. low"));
            stockQuote.setClose(latestData.get("4. close"));
            stockQuote.setVolume(latestData.get("5. volume"));

            return stockQuote;
        }

        return null;
    }
}
