package pluralsight;

public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private float hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay(){
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    public float getRegularHours(){
        if(hoursWorked > 40){
            return 40;
        }
        else{
            return hoursWorked;
        }
    }

    public float getOvertimeHours(){
//        if(hoursWorked > 40){
//            return hoursWorked - 40;
//        }
//        else{
//            return 0;
//        }
        return (hoursWorked > 40) ? hoursWorked - 40 : 0;
    }

    private double punchInTime;

    public void punchIn(double time){
        this.punchInTime = time;
    }

    public void punchOut(double punchOutTime){

        this.hoursWorked +=  (punchOutTime - this.punchInTime);

    }

}