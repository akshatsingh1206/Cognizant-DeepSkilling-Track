# LoggingExample

## Exercise 1: Logging Error Messages and Warning Levels

**Task:** Write a Java application that demonstrates logging error messages and warning levels using SLF4J.

**Step-by-Step Solution:**

1. Add SLF4J and Logback dependencies to your `pom.xml` file:
   ```xml
   <dependency>
       <groupId>org.slf4j</groupId>
       <artifactId>slf4j-api</artifactId>
       <version>1.7.30</version>
   </dependency>
   <dependency>
       <groupId>ch.qos.logback</groupId>
       <artifactId>logback-classic</artifactId>
       <version>1.2.3</version>
   </dependency>
   ```
2. Create a Java class that uses SLF4J for logging:
   ```java
   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;

   public class LoggingExample {
       private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

       public static void main(String[] args) {
           logger.error("This is an error message");
           logger.warn("This is a warning message");
       }
   }
   ```

---

## Project Structure

```
LoggingExample/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/example/
        │       └── LoggingExample.java
        └── resources/
            └── logback.xml
```

## Files

| File | Role |
|---|---|
| `pom.xml` | Maven build file with `slf4j-api` and `logback-classic` dependencies |
| `LoggingExample.java` | Demonstrates `logger.error()` and `logger.warn()` calls |
| `logback.xml` | Logback configuration defining console output format and minimum log level |

## About SLF4J and Logback

SLF4J (**Simple Logging Facade for Java**) is an abstraction layer — your code logs against the SLF4J API, and the actual logging work is done by whichever backend is on the classpath. Logback is that backend here: it controls formatting, output destination, and which log levels get printed, all configured in `logback.xml`.

## Log Levels (lowest to highest severity)

| Level | Typical use |
|---|---|
| TRACE | Very fine-grained diagnostic detail |
| DEBUG | Debugging information during development |
| INFO | General application progress/events |
| WARN | Something unexpected but not breaking |
| ERROR | A failure that needs attention |

`logback.xml` sets the root logger level to `warn`, so only `WARN` and `ERROR` messages print — `INFO`/`DEBUG`/`TRACE` calls would be suppressed if added later.

## How to Run

```bash
cd LoggingExample
mvn compile exec:java -Dexec.mainClass="com.example.LoggingExample"
```

Or, package and run the jar:
```bash
mvn package
java -cp target/classes:$(mvn -q dependency:build-classpath -Dmdep.outputFile=/dev/stdout) com.example.LoggingExample
```

Or simply run `LoggingExample.java` directly from your IDE.

## Expected Output

```
14:32:10.512 [main] ERROR com.example.LoggingExample - This is an error message
14:32:10.516 [main] WARN  com.example.LoggingExample - This is a warning message
```
