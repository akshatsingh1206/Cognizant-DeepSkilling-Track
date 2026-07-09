-- Scenario 1: Apply 1% monthly interest to all savings account balances
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    v_interest_rate CONSTANT NUMBER := 0.01; -- 1%
BEGIN
    UPDATE SavingsAccounts
    SET balance = balance + (balance * v_interest_rate);

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' savings account(s) updated with monthly interest.');

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/

-- Example call:
-- EXEC ProcessMonthlyInterest;
