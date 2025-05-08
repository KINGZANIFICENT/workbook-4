package pluralsight;

// Hotel.java

public class Hotel {
    private String name;
    private int    numberOfSuites;
    private int    numberOfRooms;
    private int    bookedSuites;
    private int    bookedBasicRooms;

    /**
     * Create a hotel with no existing bookings.
     *
     * @param name             hotel name
     * @param numberOfSuites   total suites available
     * @param numberOfRooms    total basic rooms available
     */
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name             = name;
        this.numberOfSuites   = numberOfSuites;
        this.numberOfRooms    = numberOfRooms;
        this.bookedSuites     = 0;
        this.bookedBasicRooms = 0;
    }

    /**
     * Create a hotel with existing bookings.
     *
     * @param name               hotel name
     * @param numberOfSuites     total suites available
     * @param numberOfRooms      total basic rooms available
     * @param bookedSuites       suites already booked
     * @param bookedBasicRooms   basic rooms already booked
     */
    public Hotel(String name, int numberOfSuites, int numberOfRooms,
                 int bookedSuites, int bookedBasicRooms) {
        this.name             = name;
        this.numberOfSuites   = numberOfSuites;
        this.numberOfRooms    = numberOfRooms;
        this.bookedSuites     = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    /**
     * Attempt to book a number of rooms.
     *
     * @param numberOfRooms how many rooms to book
     * @param isSuite       true = suites, false = basic rooms
     * @return true if the booking succeeded
     */
    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (bookedSuites + numberOfRooms <= this.numberOfSuites) {
                bookedSuites += numberOfRooms;
                return true;
            } else {
                return false;
            }
        } else {
            if (bookedBasicRooms + numberOfRooms <= this.numberOfRooms) {
                bookedBasicRooms += numberOfRooms;
                return true;
            } else {
                return false;
            }
        }
    }

    /** How many suites remain unbooked. */
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    /** How many basic rooms remain unbooked. */
    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }
}

