package pluralsight;// Employee.java

import java.time.LocalDateTime;

public class Employee {
    private String  employeeId;
    private String  name;
    private String  department;
    private double  payRate;
    private double  hoursWorked;
    private Double  punchInTime;    // null when not punched in

    /**
     * Primary constructor: no initial hours.
     */
    public Employee(String employeeId, String name, String department, double payRate) {
        this.employeeId   = employeeId;
        this.name         = name;
        this.department   = department;
        this.payRate      = payRate;
        this.hoursWorked  = 0.0;
        this.punchInTime  = null;
    }

    /**
     * Backwards-compatible constructor: set initial hoursWorked.
     */
    public Employee(String employeeId, String name, String department, double payRate, double initialHoursWorked) {
        this(employeeId, name, department, payRate);
        this.hoursWorked = initialHoursWorked;
    }

    /** Clock in at the specified decimal time (e.g. 9.5 = 9:30 AM). */
    public void punchIn(double time) {
        if (punchInTime != null) {
            throw new IllegalStateException("Already punched in at " + punchInTime);
        }
        punchInTime = time;
    }

    /** Clock in right now, based on system time. */
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        double current = now.getHour() + now.getMinute() / 60.0;
        punchIn(current);
    }

    /** Clock out at the specified decimal time and add it to hoursWorked. */
    public void punchOut(double time) {
        if (punchInTime == null) {
            throw new IllegalStateException("Must punch in before punching out");
        }
        double session = time - punchInTime;
        if (session < 0) {
            throw new IllegalArgumentException("Punch-out time must be after punch-in");
        }
        hoursWorked += session;
        punchInTime = null;
    }

    /** Clock out right now, based on system time. */
    public void punchOut() {
        LocalDateTime now = LocalDateTime.now();
        double current = now.getHour() + now.getMinute() / 60.0;
        punchOut(current);
    }

    /** Up to 40h at regular rate. */
    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    /** Any hours beyond 40h. */
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    /** Total pay: regular + 1.5× overtime. */
    public double getTotalPay() {
        return getRegularHours() * payRate
                + getOvertimeHours() * payRate * 1.5;
    }

    // Optional getters

    public double getHoursWorked() {
        return hoursWorked;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
