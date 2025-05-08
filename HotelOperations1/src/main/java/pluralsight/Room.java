package pluralsight;// Room.java

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    /**
     * A room is available only if it’s clean and not occupied.
     */
    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    /**
     * Check a guest into the room: now occupied and dirty.
     */
    public void checkIn() {
        if (!isAvailable()) {
            throw new IllegalStateException("Room not ready for check-in");
        }
        occupied = true;
        dirty    = true;
    }

    /**
     * Guest checks out: no longer occupied, but still dirty.
     */
    public void checkOut() {
        if (!occupied) {
            throw new IllegalStateException("Room is not occupied");
        }
        occupied = false;
        // dirty remains true until cleanRoom() is called
    }

    /**
     * Housekeeper cleans it: room is clean (but unoccupied).
     */
    public void cleanRoom() {
        if (occupied) {
            throw new IllegalStateException("Can't clean while occupied");
        }
        dirty = false;
    }
}
