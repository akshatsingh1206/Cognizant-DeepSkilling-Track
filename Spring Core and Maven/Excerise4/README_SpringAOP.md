# LibraryManagement — Exercise 3: Implementing Logging with Spring AOP

## Exercise 3: Implementing Logging with Spring AOP

**Scenario:**
The library management application requires logging capabilities to track method execution times.

**Steps:**

1. **Add Spring AOP Dependency:**
   - Update `pom.xml` to include Spring AOP dependency.
2. **Create an Aspect for Logging:**
   - Create a package `com.library.aspect` and add a class `LoggingAspect` with a method to log execution times.
3. **Enable AspectJ Support:**
   - Update `applicationContext.xml` to enable AspectJ support and register the aspect.
4. **Test the Aspect:**
   - Run the `LibraryManagementApplication` main class and observe the console for log messages indicating method execution times.

---

## This Builds on Exercises 1 & 2

Same `LibraryManagement` project. Three existing files were **updated**, one new file was **added**.

## Changes Made

### 1. `pom.xml` (updated)
Added two dependencies:
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>${spring.version}</version>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.21</version>
</dependency>
```
`spring-aop` provides Spring's proxy-based AOP framework; `aspectjweaver` supplies the `@Aspect`/`@Around` annotations Spring AOP uses (via the "AspectJ annotation style," even though Spring AOP itself is still proxy-based, not full AspectJ weaving).

### 2. `LoggingAspect.java` (new)
| File | Role |
|---|---|
| `src/main/java/com/library/aspect/LoggingAspect.java` | `@Aspect` class with an `@Around` advice method that wraps every method call in `com.library.service` and logs entry + execution time |

Pointcut expression `execution(* com.library.service.*.*(..))` breaks down as:
- first `*` — any return type
- `com.library.service.*` — any class in that package
- `.*(..)` — any method name, any arguments

### 3. `applicationContext.xml` (updated)
- Added the `aop` XML namespace.
- Added `<aop:aspectj-autoproxy />` — tells Spring to scan for `@Aspect` beans and wrap matching target beans in dynamic proxies.
- Registered `loggingAspect` as a bean, same as any other bean.

## How Spring AOP Works Here

Spring doesn't modify `BookService`'s bytecode. Instead, `aspectj-autoproxy` causes Spring to wrap `bookService` in a **proxy object**. When `LibraryManagementApplication` calls `bookService.getBookDetails(1)`, it's actually calling the proxy, which:
1. Runs `LoggingAspect.logExecutionTime()` up to the `joinPoint.proceed()` line.
2. `proceed()` invokes the *real* `BookService.getBookDetails()`.
3. Control returns to the aspect, which logs the elapsed time.

This is why the target class (`BookService`) needs zero changes — the logging is added declaratively, entirely from configuration.

## How to Run

Reuse `LibraryManagementApplication.java` from Exercise 2 — no changes needed to it:

```bash
cd LibraryManagement
mvn compile exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
```

## Expected Output

```
BookRepository bean created.
BookService bean created.
[AOP] Entering method: String com.library.service.BookService.getBookDetails(int)
[AOP] String com.library.service.BookService.getBookDetails(int) executed in 0 ms
Book #1: The Pragmatic Programmer
[AOP] Entering method: String com.library.service.BookService.getBookDetails(int)
[AOP] String com.library.service.BookService.getBookDetails(int) executed in 0 ms
Book #2: The Pragmatic Programmer
Same bean instance? true
```
