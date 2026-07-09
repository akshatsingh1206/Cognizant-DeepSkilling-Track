# LibraryManagement

## Exercise 1: Configuring a Basic Spring Application

**Scenario:**
Your company is developing a web application for managing a library. You need to use the Spring Framework to handle the backend operations.

**Steps:**

1. **Set Up a Spring Project:**
   - Create a Maven project named `LibraryManagement`.
   - Add Spring Core dependencies in the `pom.xml` file.
2. **Configure the Application Context:**
   - Create an XML configuration file named `applicationContext.xml` in the `src/main/resources` directory.
   - Define beans for `BookService` and `BookRepository` in the XML file.
3. **Define Service and Repository Classes:**
   - Create a package `com.library.service` and add a class `BookService`.
   - Create a package `com.library.repository` and add a class `BookRepository`.
4. **Run the Application:**
   - Create a main class to load the Spring context and test the configuration.

---

## Project Structure

```
LibraryManagement/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/library/
        │       ├── MainApp.java
        │       ├── service/
        │       │   └── BookService.java
        │       └── repository/
        │           └── BookRepository.java
        └── resources/
            └── applicationContext.xml
```

## Files

| File | Role |
|---|---|
| `pom.xml` | Maven build file with `spring-context`, `spring-core`, `spring-beans` dependencies |
| `applicationContext.xml` | Spring XML config defining the `bookRepository` and `bookService` beans and wiring them together |
| `BookRepository.java` | Simulated data-access class |
| `BookService.java` | Service class with a setter for `BookRepository` (used for dependency injection) |
| `MainApp.java` | Loads the Spring `ApplicationContext` and retrieves/uses the `bookService` bean |

## How Spring Wires This Together

1. `MainApp` creates a `ClassPathXmlApplicationContext`, pointing it at `applicationContext.xml`.
2. Spring reads the XML, instantiates `BookRepository` and `BookService` as **beans** (objects it manages).
3. Because `bookService`'s `<property name="bookRepository" ref="bookRepository" />` entry references the `bookRepository` bean, Spring automatically calls `bookService.setBookRepository(...)` — this is **setter-based dependency injection**.
4. `MainApp` retrieves the fully-wired `bookService` bean via `context.getBean("bookService")` and calls its methods — no `new` needed anywhere in `MainApp`.

## How to Run

```bash
cd LibraryManagement
mvn compile exec:java -Dexec.mainClass="com.library.MainApp"
```

Or run `MainApp.java` directly from your IDE (ensure `applicationContext.xml` is on the classpath, i.e. under `src/main/resources`).

## Expected Output

```
BookRepository bean created.
BookService bean created.
Retrieved: Book #1: The Pragmatic Programmer
```
