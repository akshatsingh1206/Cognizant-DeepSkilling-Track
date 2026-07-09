-- Scenario 2: Add a bonus percentage to salaries of employees in a given department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id   IN Employees.department_id%TYPE,
    p_bonus_percent   IN NUMBER
)
IS
BEGIN
    IF p_bonus_percent <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Bonus percentage must be greater than 0.');
        RETURN;
    END IF;

    UPDATE Employees
    SET salary = salary + (salary * p_bonus_percent / 100)
    WHERE department_id = p_department_id;

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employee(s) in department ' ||
                          p_department_id || ' received a ' || p_bonus_percent || '% bonus.');

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
END UpdateEmployeeBonus;
/

-- Example call:
-- EXEC UpdateEmployeeBonus(10, 5);   -- 5% bonus for department 10
