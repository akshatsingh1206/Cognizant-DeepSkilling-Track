# JUnitAAAPatternExample

## Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods in JUnit

**Scenario:**
You need to organize your tests using the Arrange-Act-Assert (AAA) pattern and use setup and teardown methods.

**Steps:**

1. Write tests using the AAA pattern.
2. Use `@Before` and `@After` annotations for setup and teardown methods.

---

## Concepts

**Arrange-Act-Assert (AAA):** a pattern for structuring the body of a test into three clear sections:
- **Arrange** — set up the inputs/state needed for the test.
- **Act** — call the method under test.
- **Assert** — verify the result is what's expected.

**Test fixture:** the fixed baseline state (objects, data) a test needs before it runs — created in `setUp()` and cleaned up in `tearDown()` so each test starts fresh and independent of others.

**`@Before` / `@After`:** JUnit 4 annotations that mark methods to run automatically before and after **each** `@Test` method in the class (not once per class — see `@BeforeClass`/`@AfterClass` for that).

## Files

| File | Role |
|---|---|
| `src/test/java/com/example/CalculatorAAATest.java` | Test class reusing `Calculator` (from Exercise 1), with `@Before`/`@After` fixtures and AAA-structured test methods |

## Prerequisites

Requires `Calculator.java` (from Exercise 1) in `src/main/java/com/example/`, and the JUnit 4 dependency in `pom.xml`.

## Execution Order (per test method)

```
setUp() → testMethod() → tearDown()
```
This repeats independently for every `@Test` in the class, so no state leaks between tests.

## How to Run

```bash
mvn test -Dtest=CalculatorAAATest
```

Or right-click `CalculatorAAATest.java` in your IDE → **Run 'CalculatorAAATest'**.

## Expected Output

```
Setup: Calculator instance created.
Teardown: Calculator instance cleared.
Setup: Calculator instance created.
Teardown: Calculator instance cleared.
Setup: Calculator instance created.
Teardown: Calculator instance cleared.
Setup: Calculator instance created.
Teardown: Calculator instance cleared.

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```
