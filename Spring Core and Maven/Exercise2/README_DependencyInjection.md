# LibraryManagement — Exercise 2: Implementing Dependency Injection

## Exercise 2: Implementing Dependency Injection

**Scenario:**
In the library management application, you need to manage the dependencies between the `BookService` and `BookRepository` classes using Spring's IoC and DI.

**Steps:**

1. **Modify the XML Configuration:**
   - Update `applicationContext.xml` to wire `BookRepository` into `BookService`.
2. **Update the `BookService` Class:**
   - Ensure that `BookService` class has a setter method for `BookRepository`.
3. **Test the Configuration:**
   - Run the `LibraryManagementApplication` main class to verify the dependency injection.

---

## This Builds on Exercise 1

`applicationContext.xml`, `BookRepository.java`, and `BookService.java` from **Exercise 1** already satisfy steps 1 and 2:

- `applicationContext.xml` already wires the beans:
  ```xml
  <bean id="bookRepository" class="com.library.repository.BookRepository" />

  <bean id="bookService" class="com.library.service.BookService">
      <property name="bookRepository" ref="bookRepository" />
  </bean>
  ```
- `BookService` already has the setter Spring calls to inject the dependency:
  ```java
  public void setBookRepository(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
  }
  ```

No changes were needed to those files — they were built with DI in mind from the start. This exercise adds the file below to fulfill step 3.

## New File

| File | Role |
|---|---|
| `LibraryManagementApplication.java` | Main class that loads the Spring context and verifies DI is working correctly |

Place it in `src/main/java/com/library/` alongside `MainApp.java` from Exercise 1 (both can coexist — each has its own `main` method).

## What This Test Verifies

1. **Injection happened** — `bookService.getBookDetails(id)` only works if `bookRepository` was successfully injected into `bookService`; if injection failed, this would throw a `NullPointerException`.
2. **Singleton scope** — fetching the `bookService` bean twice (`bookService == anotherReference`) confirms Spring returns the *same* managed instance by default, rather than creating a new object each time `getBean()` is called.

## Inversion of Control (IoC), in short

Normally, `BookService` would create its own `BookRepository` with `new BookRepository()`. With IoC, that responsibility is inverted: Spring creates both objects and *hands* `BookService` its dependency, rather than `BookService` reaching out to create one itself. This is what makes the classes loosely coupled and easy to test (e.g., swapping in a mock `BookRepository`, as in the earlier Mockito exercises).

## How to Run

```bash
cd LibraryManagement
mvn compile exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
```

Or run `LibraryManagementApplication.java` directly from your IDE.

## Expected Output

```
BookRepository bean created.
BookService bean created.
Book #1: The Pragmatic Programmer
Book #2: The Pragmatic Programmer
Same bean instance? true
```
