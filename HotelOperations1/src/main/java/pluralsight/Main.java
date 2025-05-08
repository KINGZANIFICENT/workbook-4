package pluralsight;

// Main.java

public class Main {
    public static void main(String[] args) {
        // --- Test Room (from Exercise 2/3) ---
        Room room = new Room(1, 100.0, false, false);
        room.checkIn();       // occupied & dirty
        room.checkOut();      // no longer occupied, still dirty
        room.cleanRoom();     // now clean & available
        System.out.println("Room available? " + room.isAvailable());

        // --- Test Employee (Exercise 3) ---
        // Using the 5-arg constructor so we start with 45 hours already worked
        Employee emp = new Employee("E001", "Alice", "HR", 25.0, 45);
        // punch in/out with explicit times
        emp.punchIn(9.0);
        emp.punchOut(17.5);
        System.out.printf(
                "Employee %s (%s): hoursWorked=%.2f, regular=%.2f, overtime=%.2f, totalPay=$%.2f%n",
                emp.getEmployeeId(),
                emp.getName(),
                emp.getHoursWorked(),
                emp.getRegularHours(),
                emp.getOvertimeHours(),
                emp.getTotalPay()
        );

        // --- Test Hotel (Exercise 3) ---
        Hotel hotel = new Hotel("Downtown Inn", 5, 20);
        boolean bookedSuites = hotel.bookRoom(2, true);
        boolean bookedRooms  = hotel.bookRoom(5, false);
        System.out.printf(
                "Booked 2 suites? %b, 5 basic rooms? %b%n",
                bookedSuites,
                bookedRooms
        );
        System.out.printf(
                "Suites left: %d, Basic rooms left: %d%n",
                hotel.getAvailableSuites(),
                hotel.getAvailableRooms()
        );
    }
}
