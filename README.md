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

- Screenshort 1:

  ![image](https://github.com/user-attachments/assets/550c29a7-9f5a-4f5c-bce3-4c73897adcce)

- Screenshort 2: Database Structure

  ![image](https://github.com/user-attachments/assets/02ea11fe-0486-4dc2-8603-67794b65f384)

- Screenshort 3: After hitting the url (2 times) : http://localhost:8080/api/stock-quotes/quote/RELIANCE.BSE

  ![image](https://github.com/user-attachments/assets/36f60770-74d9-4753-9fdc-02556a4f44b1)
  
  ![image](https://github.com/user-attachments/assets/676a7edc-f24d-4b3c-8dfa-dd6b7f3460ea)

  ![image](https://github.com/user-attachments/assets/75762717-0f8e-4f2e-b1dc-31b602792e70)

- Screenshort 4: After hitting the url (2 times) : [http://localhost:8080/api/stock-quotes/quote/RELIANCE.BSE](http://localhost:8080/api/stock-quotes/batch-quotes?symbols=RELIANCE.BSE,TCS.BSE,INFY.BSE)

  ![image](https://github.com/user-attachments/assets/f901fddd-3a2f-4a00-9bf7-8c67808b3ace)

  ![image](https://github.com/user-attachments/assets/8504c19f-350a-4002-b166-8adf64245999)

  ![image](https://github.com/user-attachments/assets/10f9aad6-f53e-46d9-a054-60f2a83a12c8)


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


  
