# JUnitSetupExample

## Exercise 1: Setting Up JUnit

**Scenario:**
You need to set up JUnit in your Java project to start writing unit tests.

**Steps:**

1. Create a new Java project in your IDE (e.g., IntelliJ IDEA, Eclipse).
2. Add JUnit dependency to your project. If you are using Maven, add the following to your `pom.xml`:
   ```xml
   <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.13.2</version>
       <scope>test</scope>
   </dependency>
   ```
3. Create a new test class in your project.

---

## Project Structure

```
JUnitSetupExample/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/example/
    │           └── Calculator.java
    └── test/
        └── java/
            └── com/example/
                └── CalculatorTest.java
```

## Files

| File | Role |
|---|---|
| `pom.xml` | Maven build file with the JUnit 4.13.2 dependency (test scope) |
| `src/main/java/com/example/Calculator.java` | Simple class with `add`, `subtract`, `multiply`, `divide` methods to demonstrate testing |
| `src/test/java/com/example/CalculatorTest.java` | JUnit 4 test class verifying `Calculator`'s behavior, including a divide-by-zero exception test |

## How to Set Up in Your IDE

**IntelliJ IDEA:**
1. `File > New > Project` → Maven → set project name `JUnitSetupExample`.
2. Copy `pom.xml` into the project root (or merge the dependency into your existing one).
3. Place `Calculator.java` and `CalculatorTest.java` in the folder structure shown above.
4. Right-click `CalculatorTest.java` → **Run 'CalculatorTest'**.

**Eclipse:**
1. `File > New > Maven Project` → name it `JUnitSetupExample`.
2. Copy `pom.xml` in, then right-click project → `Maven > Update Project`.
3. Add the source files in the matching package folders.
4. Right-click `CalculatorTest.java` → `Run As > JUnit Test`.

## How to Run (command line, with Maven installed)

```bash
mvn test
```

## Expected Output

```
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```
