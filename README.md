# Real-Time Stock Quotes

A Spring Boot application that fetches and stores real-time stock quotes using the Alpha Vantage API. This project includes features like batch processing, duplicate entry prevention, and seamless integration with a MySQL database.

---

## Features

- Fetch real-time or near real-time stock quotes.
- Batch processing for multiple stock symbols.
- Avoid duplicate entries using symbol and timestamp as unique identifiers.
- API integration with Alpha Vantage for stock data.
- MySQL database integration for persistent storage.
- RESTful API endpoints for single and batch stock quote retrieval.

---

## Technologies Used

- **Backend**: Spring Boot 3.x
- **Database**: MySQL
- **Security**: Spring Security
- **External API**: Alpha Vantage
- **Tools**: Maven, RestTemplate, JPA, Hibernate

---

## Prerequisites

- **JDK** 17 or higher
- **Maven** 3.8 or higher
- **MySQL** 8.x
- An **API Key** from [Alpha Vantage](https://www.alphavantage.co/).

---

## API Endpoints

### 1. Get Quote by Symbol
Fetches a single stock quote for a specified symbol.

- **Endpoint**: `GET /api/stock-quotes/quote/{symbol}`
- **Example**: 
  ```bash
  curl -X GET "http://localhost:8080/api/stock-quotes/quote/RELIANCE.BSE"

### 2. Get Batch Quotes by Symbols
Fetches stock quotes for multiple symbols.

- **Endpoin**t: GET /api/stock-quotes/batch-quotes?symbols=symbol1,symbol2
- **Example**:
  ```bash
    curl -X GET "http://localhost:8080/api/stock-quotes/batch-quotes?symbols=RELIANCE.BSE,TCS.BSE"

---

### Project Directory Structure
```plaintext
real-time-stock-quotes/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── example/
│   │   │   │   │   ├── stockquotes/
│   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   ├── StockQuoteController.java
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   ├── StockQuote.java
│   │   │   │   │   │   ├── repository/
│   │   │   │   │   │   │   ├── StockQuoteJpaRepository.java
│   │   │   │   │   │   │   ├── StockQuoteRepository.java
│   │   │   │   │   │   ├── service/
│   │   │   │   │   │   │   ├── StockQuoteService.java
│   │   │   │   │   │   ├── RealTimeStockQuotesApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
├── .gitignore
├── pom.xml
├── README.md

```

---

## How to Run the Application
### 1. Clone the repository:
  ```bash
    git clone https://github.com/yourusername/real-time-stock-quotes.git
  ```
### 2. Navigate to the project directory:
  ```bash
    cd real-time-stock-quotes
  ```
### 3. Configure application.properties:
  ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/stock_quotes_db
    spring.datasource.username=<your-username>
    spring.datasource.password=<your-password>
    alphavantage.api.key=<your-api-key>
  ```
### 4. Build the project using Maven:
  ```bash
    mvn clean install
  ```
### 5. Run the application:
  ```bash
    mvn spring-boot:run
  ```

---

## Database Schema

  ```bash
  CREATE TABLE stock_quotes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    symbol VARCHAR(50) NOT NULL,
    open DECIMAL(10, 4),
    high DECIMAL(10, 4),
    low DECIMAL(10, 4),
    close DECIMAL(10, 4),
    volume BIGINT,
    timestamp DATETIME NOT NULL,
    UNIQUE (symbol, timestamp)
  );
  ```

---

## Screenshots



---

## Future Enhancements
  - Implement caching for frequently accessed quotes.
  - Add support for more data providers.
  - Enhance security by implementing role-based access control (RBAC).
  - Containerize the application using Docker.


---

## License
  This project is licensed under the MIT License. See the LICENSE file for details.


---


## Contribute

Contributions are welcome! If you would like to contribute to this project, feel free to fork the repository, make changes, and submit a pull request.

For any questions, suggestions, or collaboration ideas, you can reach out to:

- **Name**: Pranav Sanjay Manapure  
- **Email**: [manapurepranav03@gmail.com](mailto:manapurepranav03@gmail.com)  
- **LinkedIn**: [linkedin.com/in/pranav-sanjay-manapure](https://www.linkedin.com/in/pranav-sanjay-manapure)

---


  
