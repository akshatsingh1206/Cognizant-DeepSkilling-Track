-- Scenario 3: Transfer funds between accounts, checking sufficient balance first
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id  IN Accounts.account_id%TYPE,
    p_target_account_id  IN Accounts.account_id%TYPE,
    p_amount             IN NUMBER
)
IS
    v_source_balance Accounts.balance%TYPE;
    insufficient_funds EXCEPTION;
BEGIN
    IF p_amount <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Transfer amount must be greater than 0.');
        RETURN;
    END IF;

    -- Lock the source row while checking balance to prevent race conditions
    SELECT balance INTO v_source_balance
    FROM Accounts
    WHERE account_id = p_source_account_id
    FOR UPDATE;

    IF v_source_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts
    SET balance = balance - p_amount
    WHERE account_id = p_source_account_id;

    UPDATE Accounts
    SET balance = balance + p_amount
    WHERE account_id = p_target_account_id;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from account ' ||
                          p_source_account_id || ' to account ' || p_target_account_id);

    COMMIT;

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: insufficient balance in account ' || p_source_account_id);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: source account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error transferring funds: ' || SQLERRM);
END TransferFunds;
/

-- Example call:
-- EXEC TransferFunds(101, 102, 500);
