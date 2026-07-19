# Microservices: Account and Loan

## Hands On: Creating Microservices for account and loan

In this hands-on exercise, we create two microservices for a bank. One microservice for handling accounts and one for handling loans.

Each microservice is a specific, independent Spring RESTful Webservice Maven project with its own `pom.xml`. Instead of having both account and loan as a single application, it's split into two different applications. These webservices are simple services without any backend connectivity.

**Steps followed:**

**Account Microservice**
- Create a Spring Boot project (Group: `com.cognizant`, Artifact: `account`) with **Spring Boot DevTools** and **Spring Web**.
- Implement a controller method for getting account details based on account number:
  - Method: `GET`
  - Endpoint: `/accounts/{number}`
  - Sample response (dummy, no backend connectivity): `{ number: "00987987973432", type: "savings", balance: 234343 }`
- Launch and test in browser.

**Loan Microservice**
- Same steps, Artifact: `loan`, implementing:
  - Method: `GET`
  - Endpoint: `/loans/{number}`
  - Sample response (dummy): `{ number: "H00987987972342", type: "car", loan: 400000, emi: 3258, tenure: 18 }`
- Since both services default to port 8080, running loan while account is already running fails with a **port already in use** error.
- Fix: set `server.port=8081` for the loan service, then both run simultaneously on different ports.

---

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

Place both `account/` and `loan/` folders inside your `D:\<employee_id>\microservices\` folder as separate, independent Maven projects — each imported into Eclipse individually.

## Files

| Project | File | Role |
|---|---|---|
| account | `pom.xml` | Spring Boot Maven config with `spring-boot-starter-web` and `spring-boot-devtools` |
| account | `AccountApplication.java` | `@SpringBootApplication` entry point |
| account | `AccountController.java` | `@RestController` exposing `GET /accounts/{number}` |
| account | `application.properties` | Runs on default port 8080 |
| loan | `pom.xml` | Same setup, artifact `loan` |
| loan | `LoanApplication.java` | `@SpringBootApplication` entry point |
| loan | `LoanController.java` | `@RestController` exposing `GET /loans/{number}` |
| loan | `application.properties` | Sets `server.port=8081` to avoid the port conflict with account |

## How to Run

**Account service:**
```bash
cd account
mvn clean package
mvn spring-boot:run
```
Test at: `http://localhost:8080/accounts/00987987973432`

**Loan service** (in a separate terminal/console, while account is still running):
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
- If you run both in Eclipse, use the **Console view's monitor icon (Display Selected Console)** to switch between the two running application consoles.
- Each project's `pom.xml` uses `spring-boot-starter-parent` version `2.7.18` — adjust if your Spring Initializr download used a different version.
