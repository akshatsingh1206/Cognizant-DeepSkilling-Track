# PLSQL_StoredProcedures

## Exercise 3: Stored Procedures

### Scenario 1: Monthly Interest Processing
The bank needs to process monthly interest for all savings accounts.

**Question:** Write a stored procedure `ProcessMonthlyInterest` that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.

### Scenario 2: Employee Bonus Scheme
The bank wants to implement a bonus scheme for employees based on their performance.

**Question:** Write a stored procedure `UpdateEmployeeBonus` that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

### Scenario 3: Fund Transfer Between Accounts
Customers should be able to transfer funds between their accounts.

**Question:** Write a stored procedure `TransferFunds` that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.

---

## Assumed Schema

```sql
SavingsAccounts(account_id, balance)
Employees(employee_id, department_id, salary)
Accounts(account_id, balance)
```

Adjust table/column names in the scripts if your actual schema differs.

## Files

| File | Scenario | Procedure | Parameters |
|---|---|---|---|
| `ProcessMonthlyInterest.sql` | 1 | `ProcessMonthlyInterest` | none |
| `UpdateEmployeeBonus.sql` | 2 | `UpdateEmployeeBonus` | `p_department_id`, `p_bonus_percent` |
| `TransferFunds.sql` | 3 | `TransferFunds` | `p_source_account_id`, `p_target_account_id`, `p_amount` |

## Key Concepts Used

| Concept | Where it's used |
|---|---|
| Set-based `UPDATE` (no cursor needed) | Scenario 1, 2 — bulk update across matching rows |
| IN parameters | Scenario 2, 3 |
| `SELECT ... FOR UPDATE` | Scenario 3 — locks the row to prevent race conditions during balance check |
| Custom exception (`insufficient_funds`) | Scenario 3 |
| `SQL%ROWCOUNT` | Scenario 1, 2 — reports how many rows were affected |
| Exception handling + `ROLLBACK` | All three, for safe error recovery |

## How to Run

Compile the procedures, then call them with `EXEC`:

```sql
SET SERVEROUTPUT ON;

@ProcessMonthlyInterest.sql
EXEC ProcessMonthlyInterest;

@UpdateEmployeeBonus.sql
EXEC UpdateEmployeeBonus(10, 5);   -- 5% bonus for department 10

@TransferFunds.sql
EXEC TransferFunds(101, 102, 500); -- transfer 500 from account 101 to 102
```

## Notes

- `TransferFunds` uses `FOR UPDATE` to lock the source account row before checking its balance, preventing two simultaneous transfers from overdrawing the account.
- All procedures `COMMIT` on success and `ROLLBACK` on error, keeping the database consistent.
- Bonus/interest percentages are passed or hardcoded as decimals/percent — adjust `p_bonus_percent` usage if your business rule expects a fraction (e.g., `0.05`) instead of a whole number (`5`).
