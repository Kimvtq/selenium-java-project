# Selenium Java Automation Framework with Jenkins CI/CD

This repository contains an automated testing framework using **Java + Selenium + TestNG**.  
It is integrated with **Jenkins CI/CD** for automated execution after pull request merges to `main`.

## 🚀 Features

- Browser-based testing using **Selenium WebDriver**
- Test orchestration using **TestNG**
- Maven-based build & dependency management
- CI/CD pipeline triggered by **PR merges into main branch**
- HTML test reports published in Jenkins
- Supports test suite selection (Dev, QA, Staging)

## 🗂️ Project Structure

```
src/test/java         # Test scripts
src/main/java         # Page objects & utilities
testng-dev.xml        # Dev test suite
testng-qa.xml         # QA test suite
testng-staging.xml    # Staging test suite
Jenkinsfile           # Jenkins CI pipeline definition
pom.xml               # Maven config
```

## 🛠️ Prerequisites

- Java 8+
- Maven 3.6+
- Jenkins with these plugins installed:
  - **GitHub Branch Source**
  - **Pipeline**
  - **HTML Publisher**

## 🚦 Running Tests Locally

```
# Clean and run tests with Dev suite
mvn clean test -DsuiteXmlFile=testng-dev.xml
```

## 🔄 CI/CD Pipeline

The provided `Jenkinsfile` does the following:

- **Triggers** only when a PR is merged into `main`
- Checks out code
- Builds project with Maven
- Runs selected TestNG suite
- Publishes **HTML test reports** and **JUnit results** in Jenkins
- Archives test artifacts

### 🔧 Test Suite Selection in Jenkins

When starting a pipeline run, choose from:

- `testng-dev.xml`
- `testng-qa.xml`
- `testng-staging.xml`

## 📊 Test Reports

- JUnit XML reports are archived in Jenkins.
- An HTML report (`emailable-report.html`) is available as a **clickable report** in Jenkins build results.

## 👇 Example Jenkinsfile Trigger Condition

The pipeline runs **only** on merge to `main` branch:

```groovy
when {
    allOf {
        expression { env.CHANGE_ID == null } // Not a PR
        branch 'main' // Only main branch
    }
}
```

---

## 💪 Happy Testing!
