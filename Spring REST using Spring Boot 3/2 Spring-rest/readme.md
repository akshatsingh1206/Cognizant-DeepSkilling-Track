# Spring Boot RESTful Web Services

## Overview

This project demonstrates the implementation of basic RESTful Web Services using the Spring Boot framework.

The project covers three REST APIs:

1. Hello World REST Service
2. Get India Country Details
3. Get Country by Country Code (Case Insensitive)

It also demonstrates loading Spring beans from an XML configuration file and exposing them through REST endpoints.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Core
- Maven
- SLF4J Logging

---

## Project Structure

```text
spring-learn
│
├── pom.xml
│
├── src
│   ├── main
│   │
│   ├── java
│   │   └── com
│   │       └── cognizant
│   │           └── springlearn
│   │
│   │               SpringLearnApplication.java
│   │
│   │               ├── controller
│   │               │      HelloController.java
│   │               │      CountryController.java
│   │               │
│   │               ├── model
│   │               │      Country.java
│   │               │
│   │               └── service
│   │                      CountryService.java
│   │
│   └── resources
│          application.properties
│          country.xml
│
└── src/test/java
```

---

## REST APIs

### 1. Hello World

**Request**

```
GET /hello
```

**URL**

```
http://localhost:8083/hello
```

**Response**

```
Hello World!!
```

---

### 2. Get India

**Request**

```
GET /country
```

**URL**

```
http://localhost:8083/country
```

**Response**

```json
{
    "code": "IN",
    "name": "India"
}
```

---

### 3. Get Country by Country Code

**Request**

```
GET /countries/{code}
```

Examples

```
http://localhost:8083/countries/IN
http://localhost:8083/countries/in
http://localhost:8083/countries/In
```

**Response**

```json
{
    "code": "IN",
    "name": "India"
}
```

The country code comparison is case-insensitive.

---

## XML Configuration

The project uses **country.xml** located in

```
src/main/resources
```

Example bean configuration:

```xml
<bean id="india"
      class="com.cognizant.springlearn.model.Country">

    <property name="code" value="IN"/>
    <property name="name" value="India"/>

</bean>
```

---

## Spring Concepts Demonstrated

- Spring Boot
- Spring Web
- REST Controller
- @GetMapping
- @PathVariable
- Dependency Injection (@Autowired)
- XML Bean Configuration
- ApplicationContext
- ClassPathXmlApplicationContext
- JSON Serialization
- Logging using SLF4J

---

## Running the Project

1. Clone the repository.

2. Open the project in Eclipse or IntelliJ IDEA.

3. Run

```
SpringLearnApplication.java
```

4. Open a browser or Postman and test:

```
GET http://localhost:8083/hello

GET http://localhost:8083/country

GET http://localhost:8083/countries/in
```

---

## Expected Output

### /hello

```
Hello World!!
```

### /country

```json
{
    "code":"IN",
    "name":"India"
}
```

### /countries/in

```json
{
    "code":"IN",
    "name":"India"
}
```

---

## Learning Outcomes

This project demonstrates:

- Creating REST APIs using Spring Boot
- Handling HTTP GET requests
- Returning Java objects as JSON responses
- Loading Spring beans from XML configuration
- Using path variables in REST endpoints
- Implementing service and controller layers
- Logging request execution using SLF4J