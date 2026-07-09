# Difference Between JPA, Hibernate and Spring Data JPA

## Answer (Exam Style)

### Java Persistence API (JPA)

-   JPA (Java Persistence API) is a **Java specification (JSR 338)** for
    Object-Relational Mapping (ORM).
-   It defines a standard way to map Java objects to database tables.
-   JPA **does not provide an implementation**; it only specifies
    interfaces, annotations, and rules.
-   Examples of JPA annotations include `@Entity`, `@Table`, `@Id`, and
    `@Column`.

### Hibernate

-   Hibernate is an **ORM framework** and one of the most popular
    **implementations of JPA**.
-   It converts Java objects into database records and database records
    back into Java objects.
-   Hibernate automatically generates SQL queries and manages sessions,
    transactions, caching, and object mapping.
-   It reduces the need to write SQL manually.

### Spring Data JPA

-   Spring Data JPA is a **Spring Framework module** built on top of
    JPA.
-   It does **not implement JPA** itself; instead, it uses a JPA
    provider such as Hibernate.
-   It reduces boilerplate code by providing ready-made repository
    interfaces like `JpaRepository`.
-   It simplifies CRUD operations, query methods, and transaction
    management.

## Comparison Table

  ----------------------------------------------------------------------------------
  Feature          JPA             Hibernate           Spring Data JPA
  ---------------- --------------- ------------------- -----------------------------
  Type             Specification   ORM Framework       Spring Module

  Implementation   No              Yes                 No (uses Hibernate/JPA)

  Purpose          Defines ORM     Implements JPA      Simplifies JPA usage
                   standards                           

  SQL Generation   No              Yes                 Yes (through Hibernate)

  Boilerplate Code More            Moderate            Very Less
  ----------------------------------------------------------------------------------

## Relationship

    Spring Data JPA
            ↓
          JPA
            ↓
       Hibernate
            ↓
        MySQL/Oracle

## Conclusion

-   **JPA** defines the standard for persistence.
-   **Hibernate** is an ORM framework that implements JPA.
-   **Spring Data JPA** is a higher-level abstraction that uses
    Hibernate to simplify database operations by reducing boilerplate
    code.

### One-Line Difference

**JPA defines the rules, Hibernate implements the rules, and Spring Data
JPA makes Hibernate easier to use.**
