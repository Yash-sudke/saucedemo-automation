
# # SauceDemo Automation Testing

This project automates the testing of key functionalities of the SauceDemo/Swag Labs website:
🔗 https://www.saucedemo.com/


## Documentation

## ⚙️ Tech Stack
- **Selenium WebDriver (Java)**
- **TestNG (Testing Framework)**
- **Maven (Build Tool)**
- **Apache POI (Excel Data-Driven Testing)**
- **Extent Reports (Reporting)**

---

## 🚀 Features Automated
✅ Login functionality

✅ Product Filtering (Low to High Price)

✅ Cart Operations

✅ Checkout Process

---

## 🔧 Setup Instructions
1. Clone repo:
   ```bash
   git clone https://github.com/Yash-sudke/saucedemo-automation.git
   cd saucedemo-automation

## Tools

Automation Framework: Selenium WebDriver (Java)

Build Tool: Maven

Test Framework: TestNG

Data Source: Excel (.CSV)

Reporting: Extent Reports


## Installation

Install my-project with npm

```bash
  mvn clean install

```
    
## Project Structure

Saucedemo_Automation/
│── src/main/java/com/qa/base        # Base classes (WebDriver setup, properties)
│── src/main/java/com/qa/pages       # Page Object Model (Login, Home, Cart, Checkout)
│── src/test/java/com/qa/test        # Test Classes
│── src/test/resources/testdata      # Test Data (Excel/CSV/JSON)
│── reports/                         # Extent Reports
│── pom.xml                          # Maven dependencies
│── README.md                        # Project Documentation


## Environment Variables
```bash

Install Required Tools

Java JDK 11+

Maven

Git

Any IDE (Eclipse / IntelliJ / VS Code)
```


## Clone Repository

```bash
git clone https://github.com/Yash-sudke/saucedemo-automation.git
cd saucedemo-automation
```

## Install Dependencies

```bash
mvn clean install
```

```bash
Run Tests
```

```bash
mvn test
```

## View reports

```bash

After execution, open reports/ExtentReport.html in a browser.
```





## Details

Test Scenarios Automated

1. Login Functionality

Positive: Valid username & password → Homepage loads

Negative: Invalid credentials → Error message displayed


2. Product Filtering

Sort products by Price (Low → High)

Validate that order is correct


3. Cart Operations

Add product to cart

Verify product is visible in cart


4. Checkout Process

Proceed to checkout

Fill in details & place order

Verify order confirmation message


## Authors

Yash Sudke

