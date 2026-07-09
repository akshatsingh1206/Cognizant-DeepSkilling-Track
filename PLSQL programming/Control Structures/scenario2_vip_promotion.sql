-- Scenario 2: Set IsVIP = TRUE for customers with balance > $10,000
DECLARE
    CURSOR cust_cursor IS
        SELECT customer_id, balance FROM Customers;
    v_customer_id Customers.customer_id%TYPE;
    v_balance     Customers.balance%TYPE;
BEGIN
    OPEN cust_cursor;
    LOOP
        FETCH cust_cursor INTO v_customer_id, v_balance;
        EXIT WHEN cust_cursor%NOTFOUND;

        IF v_balance > 10000 THEN
            UPDATE Customers
            SET is_vip = 'Y'   -- use 1/0 or 'TRUE'/'FALSE' if your column is NUMBER or VARCHAR2
            WHERE customer_id = v_customer_id;

            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || ' promoted to VIP');
        END IF;
    END LOOP;
    CLOSE cust_cursor;

    COMMIT;
END;
/
