// Employee.java
public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    /** Up to 40h at regular rate */
    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    /** Any hours beyond 40h */
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    /** Total pay: regular + 1.5× overtime */
    public double getTotalPay() {
        return getRegularHours() * payRate
                + getOvertimeHours() * payRate * 1.5;
    }

    // (Optional) other getters/setters...
}
