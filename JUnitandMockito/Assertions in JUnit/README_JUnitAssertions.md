# JUnitAssertionsExample

## Exercise 3: Assertions in JUnit

**Scenario:**
You need to use different assertions in JUnit to validate your test results.

**Steps:**

1. Write tests using various JUnit assertions.

**Provided Solution Code:**

```java
public class AssertionsTest {
    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);
        // Assert true
        assertTrue(5 > 3);
        // Assert false
        assertFalse(5 < 3);
        // Assert null
        assertNull(null);
        // Assert not null
        assertNotNull(new Object());
    }
}
```

---

## Files

| File | Role |
|---|---|
| `src/test/java/com/example/AssertionsTest.java` | Complete, runnable version of the solution — adds the package declaration and static imports needed to compile |

## Assertions Used

| Assertion | Purpose |
|---|---|
| `assertEquals(expected, actual)` | Checks two values are equal |
| `assertTrue(condition)` | Checks a condition evaluates to `true` |
| `assertFalse(condition)` | Checks a condition evaluates to `false` |
| `assertNull(object)` | Checks an object reference is `null` |
| `assertNotNull(object)` | Checks an object reference is not `null` |

## Prerequisites

Requires the JUnit 4 dependency (`junit:junit:4.13.2`) already added in Exercise 1's `pom.xml`. Place this file inside the same Maven project's `src/test/java/com/example/` folder.

## How to Run

```bash
mvn test -Dtest=AssertionsTest
```

Or right-click `AssertionsTest.java` in your IDE → **Run 'AssertionsTest'**.

## Expected Output

```
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```
