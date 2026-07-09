# PLSQL_ControlStructures

## Exercise 1: Control Structures

### Scenario 1: Senior Citizen Loan Discount
The bank wants to apply a discount to loan interest rates for customers above 60 years old.

**Question:** Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

### Scenario 2: VIP Status Promotion
A customer can be promoted to VIP status based on their balance.

**Question:** Write a PL/SQL block that iterates through all customers and sets a flag `IsVIP` to `TRUE` for those with a balance over $10,000.

### Scenario 3: Loan Due Reminders
The bank wants to send reminders to customers whose loans are due within the next 30 days.

**Question:** Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

---

## Assumed Schema

```sql
Customers(customer_id, name, age, balance, is_vip)
Loans(loan_id, customer_id, interest_rate, due_date)
```

Adjust table/column names in the scripts if your actual schema differs.

## Files

| File | Scenario | What it does |
|---|---|---|
| `scenario1_senior_discount.sql` | 1 | Applies 1% interest discount to loans of customers aged over 60 |
| `scenario2_vip_promotion.sql` | 2 | Sets `is_vip` flag for customers with balance > $10,000 |
| `scenario3_loan_due_reminders.sql` | 3 | Prints reminder messages for loans due within 30 days |

## Key Concepts Used

| Concept | Where it's used |
|---|---|
| Explicit cursor + loop | All three scenarios (`OPEN` / `FETCH` / `EXIT WHEN` / `CLOSE`) |
| `IF` condition | Scenario 1 (age check), Scenario 2 (balance check) |
| `UPDATE` inside a loop | Scenario 1, Scenario 2 |
| `JOIN` in cursor query | Scenario 3 |
| `DBMS_OUTPUT.PUT_LINE` | All three, for printing messages/reminders |

## How to Run

Run each `.sql` file in SQL*Plus, SQL Developer, or any Oracle PL/SQL environment:

```sql
SET SERVEROUTPUT ON;
@scenario1_senior_discount.sql
@scenario2_vip_promotion.sql
@scenario3_loan_due_reminders.sql
```

`SET SERVEROUTPUT ON` is required to see `DBMS_OUTPUT.PUT_LINE` messages in the console.

## Notes

- `IsVIP` is modeled as `CHAR(1)` (`'Y'`/`'N'`) in `scenario2_vip_promotion.sql` since Oracle SQL tables don't have a native `BOOLEAN` column type. Adjust to `1`/`0` if your column is `NUMBER(1)` instead.
- All `UPDATE` blocks include a `COMMIT` at the end to persist changes.
