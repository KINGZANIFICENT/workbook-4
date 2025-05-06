package pluralsight;

public class Main {
    public static void main(String[] args) {
        //testReservation1();
        testEmployee();
        //testRoom();
    }


    public static void testEmployee(){

        Employee e1 = new Employee(1, "Brandon", "Facilitators", 10);
        //e1.setHoursWorked(39);
        //monday
        e1.punchIn(8);
        e1.punchOut(17);

        //tues
        e1.punchIn(8);
        e1.punchOut(17);

        //wed
        e1.punchIn(8);
        e1.punchOut(17);

        //thu
        e1.punchIn(8);
        e1.punchOut(17);

        //fri
        e1.punchIn(8);
        e1.punchOut(17);



        System.out.println(e1.getTotalPay());

        Employee e2 = new Employee(1, "Angel", "Facilitators", 10);
        //e2.setHoursWorked(40);
        System.out.println(e2.getTotalPay());

        Employee e3 = new Employee(1, "Matt", "Facilitators", 10);
        //e3.setHoursWorked(41);
        System.out.println(e3.getTotalPay());



    }

    public static void testRoom(){
        Room r1 = new Room(1,150);
        System.out.println(r1.isAvailable());
        r1.checkIn();
        System.out.println(r1.isAvailable());
    }

    public static void testReservation1() {
        Reservation r1 = new Reservation("king", false, 1);
        System.out.println(r1.getPrice());

        Reservation r2 = new Reservation("double", false, 1);
        System.out.println(r2.getPrice());

        Reservation r3 = new Reservation("king", true, 1);
        System.out.println(r3.getPrice());

        Reservation r4 = new Reservation("double", true, 1);
        System.out.println(r4.getPrice());

    }
}