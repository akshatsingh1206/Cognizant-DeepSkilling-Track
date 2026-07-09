-- Scenario 1: Apply 1% interest discount to loans of customers above 60
DECLARE
    CURSOR cust_cursor IS
        SELECT customer_id, age FROM Customers;
    v_customer_id Customers.customer_id%TYPE;
    v_age         Customers.age%TYPE;
BEGIN
    OPEN cust_cursor;
    LOOP
        FETCH cust_cursor INTO v_customer_id, v_age;
        EXIT WHEN cust_cursor%NOTFOUND;

        IF v_age > 60 THEN
            UPDATE Loans
            SET interest_rate = interest_rate - (interest_rate * 0.01)
            WHERE customer_id = v_customer_id;

            DBMS_OUTPUT.PUT_LINE('Discount applied for Customer ID: ' || v_customer_id);
        END IF;
    END LOOP;
    CLOSE cust_cursor;

    COMMIT;
END;
/
