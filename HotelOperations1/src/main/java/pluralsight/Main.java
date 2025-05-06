package pluralsight;

// Main.java
public class Main {
    public static void main(String[] args) {
        // --- Test Room ---
        Room r = new Room(2, 150.0, false, false);
        System.out.printf("Room: %d beds, $%.2f/night, available? %b%n",
                r.getNumberOfBeds(), r.getPrice(), r.isAvailable());

        // --- Test Reservation ---
        Reservation res = new Reservation("King", 3, true);
        System.out.printf("Reservation: %s room, %d nights, weekend? %b%n",
                res.getRoomType(), res.getNumberOfNights(), res.isWeekend());
        System.out.printf("  → Price/night: $%.2f, Total: $%.2f%n",
                res.getPrice(), res.getReservationTotal());

        // --- Test Employee ---
        Employee e = new Employee("E001", "Alice", "HR", 25.0, 45);
        System.out.printf("Employee %s (%s): regular=%.1fh, overtime=%.1fh, total pay=$%.2f%n",
                e.employeeId, e.name, e.getRegularHours(), e.getOvertimeHours(), e.getTotalPay());
    }
}
