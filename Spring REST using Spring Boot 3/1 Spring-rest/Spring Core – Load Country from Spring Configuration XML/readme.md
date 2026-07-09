# Spring Core – Load Country from Spring XML Configuration

## Overview

This project demonstrates the basics of the **Spring Core IoC Container** using **XML-based bean configuration**.

A `Country` bean is defined in an XML configuration file (`country.xml`) and loaded into the application using `ClassPathXmlApplicationContext`. The application retrieves the bean from the Spring container and displays the configured country details.

This exercise covers:

- Spring IoC Container
- XML Bean Configuration
- Dependency Injection
- ApplicationContext
- Bean lifecycle
- Logging using SLF4J

---

## Country Configured

| Code | Name  |
| ---- | ----- |
| IN   | India |

The country information is configured inside `country.xml`.

---

## Files Added

```
SpringLearn/
│
├── Country.java
├── SpringLearnApplication.java   (Modified)
└── resources
    └── country.xml
```

---

## How It Works

1. The application starts.
2. Spring loads `country.xml`.
3. The IoC container creates the `Country` bean.
4. Spring injects the configured property values.
5. The application retrieves the bean using `getBean()`.
6. The country details are displayed in the console.

---

## Expected Output

```
Inside main()

Start

Inside Country Constructor.

Inside setCode()

Inside setName()

Country : Country [code=IN, name=India]

End
```

---

## Spring Concepts Demonstrated

- XML Bean Configuration
- `<bean>` and `<property>` tags
- Dependency Injection
- `ApplicationContext`
- `ClassPathXmlApplicationContext`
- Bean Creation
- Bean Retrieval using `getBean()`

---

## Project Structure

```
spring-core-xml/
├── Country.java
├── SpringLearnApplication.java
└── country.xml
```

---

## Note

This repository is a collection of Spring Framework laboratory exercises.

Instead of generating a new Spring Boot project for every hands-on assignment, only the files that were added or modified for this exercise have been included in a separate folder.

To run this exercise:

1. Create a Spring Boot project using **Spring Initializr** with the required dependencies.
2. Copy the files from this folder into the generated project.
3. Run `SpringLearnApplication`.

This approach avoids committing multiple copies of the same Spring Boot boilerplate while keeping the repository focused on the concepts implemented in each hands-on exercise.
