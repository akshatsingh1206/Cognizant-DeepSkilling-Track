# Microservices: Account and Loan

## Overview

This hands-on exercise builds two independent microservices for a bank:

- **Account service** — handles account details
- **Loan service** — handles loan details

Rather than bundling both into one application, each is a separate, self-contained Spring Boot RESTful web service with its own `pom.xml`. Neither service has real backend connectivity — both return dummy/sample data.

## Project Structure

```
microservices/
├── account/
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/cognizant/account/
│       │   ├── AccountApplication.java
│       │   └── controller/
│       │       └── AccountController.java
│       └── resources/
│           └── application.properties      (server.port=8080)
└── loan/
    ├── pom.xml
    └── src/main/
        ├── java/com/cognizant/loan/
        │   ├── LoanApplication.java
        │   └── controller/
        │       └── LoanController.java
        └── resources/
            └── application.properties      (server.port=8081)
```

Place both `account/` and `loan/` folders inside `D:\<employee_id>\microservices\` as separate, independent Maven projects, each imported into Eclipse individually.

## Setup Steps

### 1. Account Microservice

1. Create a Spring Boot project — Group: `com.cognizant`, Artifact: `account` — with **Spring Boot DevTools** and **Spring Web** dependencies.
2. Implement a controller method for retrieving account details by account number:
   - **Method:** `GET`
   - **Endpoint:** `/accounts/{number}`
   - **Sample response:**
     ```json
     { "number": "00987987973432", "type": "savings", "balance": 234343 }
     ```
3. Launch the service and verify the response in a browser.

### 2. Loan Microservice

1. Repeat the same setup — Artifact: `loan` — with the same dependencies.
2. Implement the equivalent controller method:
   - **Method:** `GET`
   - **Endpoint:** `/loans/{number}`
   - **Sample response:**
     ```json
     { "number": "H00987987972342", "type": "car", "loan": 400000, "emi": 3258, "tenure": 18 }
     ```
3. **Port conflict:** both services default to port `8080`. Starting `loan` while `account` is already running fails with a *port already in use* error.
   - **Fix:** set `server.port=8081` in the loan service's `application.properties`, then run both simultaneously without conflict.

## Files Reference

| Project | File | Role |
|---|---|---|
| account | `pom.xml` | Spring Boot Maven config with `spring-boot-starter-web` and `spring-boot-devtools` |
| account | `AccountApplication.java` | `@SpringBootApplication` entry point |
| account | `AccountController.java` | `@RestController` exposing `GET /accounts/{number}` |
| account | `application.properties` | Runs on default port `8080` |
| loan | `pom.xml` | Same setup, artifact `loan` |
| loan | `LoanApplication.java` | `@SpringBootApplication` entry point |
| loan | `LoanController.java` | `@RestController` exposing `GET /loans/{number}` |
| loan | `application.properties` | Sets `server.port=8081` to avoid conflict with account |

## How to Run

**Account service:**
```bash
cd account
mvn clean package
mvn spring-boot:run
```
Test at: `http://localhost:8080/accounts/00987987973432`

**Loan service** (in a separate terminal, while account is still running):
```bash
cd loan
mvn clean package
mvn spring-boot:run
```
Test at: `http://localhost:8081/loans/H00987987972342`

## Expected Responses

`GET http://localhost:8080/accounts/00987987973432`
```json
{"number":"00987987973432","type":"savings","balance":234343}
```

`GET http://localhost:8081/loans/H00987987972342`
```json
{"number":"H00987987972342","type":"car","loan":400000,"emi":3258,"tenure":18}
```

## Notes

- `@PathVariable` is used in both controllers to capture the `{number}` segment from the URL, so the response always echoes back whatever account/loan number was requested.
- In Eclipse, use the **Console view's monitor icon** (Display Selected Console) to switch between the two running application consoles.
- Each project's `pom.xml` uses `spring-boot-starter-parent` version `2.7.18` — adjust if your Spring Initializr download used a different version.
