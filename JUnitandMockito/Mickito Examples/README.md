# MockitoExample

## Exercise 1: Mocking and Stubbing

**Scenario:**
You need to test a service that depends on an external API. Use Mockito to mock the external API and stub its methods.

**Steps:**

1. Create a mock object for the external API.
2. Stub the methods to return predefined values.
3. Write a test case that uses the mock object.

## Exercise 2: Verifying Interactions

**Scenario:**
You need to ensure that a method is called with specific arguments.

**Steps:**

1. Create a mock object.
2. Call the method with specific arguments.
3. Verify the interaction.

---

## Project Structure

```
MockitoExample/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/example/
    │           ├── ExternalApi.java
    │           └── MyService.java
    └── test/
        └── java/
            └── com/example/
                └── MyServiceTest.java
```

## Files

| File | Role |
|---|---|
| `pom.xml` | Maven build file with JUnit 5 (Jupiter) and Mockito dependencies |
| `ExternalApi.java` | Interface representing the external API dependency (the thing being mocked) |
| `MyService.java` | Service class under test; depends on `ExternalApi` via constructor injection |
| `MyServiceTest.java` | Contains both test methods: `testExternalApi()` (Exercise 1 — mocking/stubbing) and `testVerifyInteraction()` (Exercise 2 — verifying interactions) |

## Why Constructor Injection?

`MyService` takes `ExternalApi` as a constructor parameter rather than creating it internally. This is what makes mocking possible — the test can pass in a fake (`mockApi`) instead of a real implementation, with no changes to `MyService`'s code.

## Key Mockito Concepts

| Concept | API used | What it does |
|---|---|---|
| Creating a mock | `mock(ExternalApi.class)` | Generates a fake object implementing `ExternalApi` with no real behavior |
| Stubbing | `when(mockApi.getData()).thenReturn("Mock Data")` | Defines what the mock returns when that method is called |
| Verifying interaction | `verify(mockApi).getData()` | Asserts that `getData()` was actually called on the mock during the test |

## How to Run

```bash
cd MockitoExample
mvn test
```

Or run `MyServiceTest.java` directly from your IDE (IntelliJ/Eclipse with JUnit 5 support).

## Expected Output

```
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## Note on Imports

The original solution snippets used `org.junit.jupiter.api.Test` (JUnit 5) — this project's `pom.xml` is set up for JUnit 5 + Mockito accordingly (not the JUnit 4 setup used in earlier exercises). `assertEquals` is imported from `org.junit.jupiter.api.Assertions` to match.
