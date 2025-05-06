
# CBTW Selenium Java

A **Java Selenium** test automation framework using **TestNG** and **Maven**, designed for web application testing across different environments (Dev, QA, Staging).

---

## Features

- ✅ Selenium WebDriver for browser automation
- ✅ TestNG for organizing and executing tests
- ✅ Maven for dependency management and build
- ✅ Environment-specific TestNG suites (`dev`, `qa`, `staging`)


---

## Project Structure

```
cbtw-selenium-java/
├── pom.xml               # Maven config file
├── testng-dev.xml        # Test suite for Dev environment
├── testng-qa.xml         # Test suite for QA environment
├── testng-staging.xml    # Test suite for Staging environment
├── src/test/java/        # Test cases and test logic
└── .idea/                # IDE config (optional)
```

---

## Prerequisites

- Java JDK 8 or higher
- Maven 3.6+
- ChromeDriver (depending on browser target)

---

## Setup & Install

1. **Clone the repo**

```bash
git clone https://github.com/Kimvtq/selenium-java-project.git
```

2. **Install dependencies**

```bash
mvn clean install
```

---

## Running Tests

### Run Dev Suite
```bash
mvn clean test -Pdev
```

### Run QA Suite
```bash
mvn clean test -Pqa
```

### Run Staging Suite
```bash
mvn clean test -Pstaging
```

---


## Customize

- Modify the `testng-*.xml` files to add/remove test classes.
- Update `pom.xml` to manage dependencies.

---

