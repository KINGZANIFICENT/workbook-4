package pluralsight;

// EmployeeTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testPunchInOutCalculatesHours() {
        Employee emp = new Employee("E001","Test","Dept",20.0);
        emp.punchIn(8.0);
        emp.punchOut(12.5);
        assertEquals(4.5, emp.getHoursWorked(), 0.0001,
                "Employee should have 4.5 hours worked after punching out");
    }

    @Test
    public void testPunchOutWithoutPunchInThrows() {
        Employee emp = new Employee("E002","Test2","Dept",20.0);
        assertThrows(IllegalStateException.class, () -> emp.punchOut(10.0),
                "Punching out without punching in should throw");
    }

    @Test
    public void testDoublePunchInThrows() {
        Employee emp = new Employee("E003","Test3","Dept",20.0);
        emp.punchIn(9.0);
        assertThrows(IllegalStateException.class, () -> emp.punchIn(10.0),
                "Punching in twice without punching out should throw");
    }

    @Test
    public void testPunchOutBeforePunchInTimeThrows() {
        Employee emp = new Employee("E004","Test4","Dept",20.0);
        emp.punchIn(12.0);
        assertThrows(IllegalArgumentException.class, () -> emp.punchOut(11.0),
                "Punching out before punch-in time should throw");
    }
}
