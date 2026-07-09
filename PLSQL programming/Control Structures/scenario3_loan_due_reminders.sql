-- Scenario 3: Print reminders for loans due within the next 30 days
DECLARE
    CURSOR loan_cursor IS
        SELECT l.loan_id, l.customer_id, c.name, l.due_date
        FROM Loans l
        JOIN Customers c ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;

    v_loan_id     Loans.loan_id%TYPE;
    v_customer_id Loans.customer_id%TYPE;
    v_name        Customers.name%TYPE;
    v_due_date    Loans.due_date%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_customer_id, v_name, v_due_date;
        EXIT WHEN loan_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID ' || v_loan_id ||
            ' for Customer ' || v_name ||
            ' (ID: ' || v_customer_id || ')' ||
            ' is due on ' || TO_CHAR(v_due_date, 'DD-MON-YYYY')
        );
    END LOOP;
    CLOSE loan_cursor;
END;
/
