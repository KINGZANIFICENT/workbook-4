package pluralsight;

public class Room {

    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = false;
        this.dirty = false;
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

//    public void setOccupied(boolean occupied) {
//        this.occupied = occupied;
//    }

    public boolean isDirty() {
        return dirty;
    }

//    public void setDirty(boolean dirty) {
//        this.dirty = dirty;
//    }

    public boolean isAvailable() {
        return (!occupied) && (!dirty);
    }

    public void checkIn(){
        this.occupied = true;
        this.dirty = true;
    }

    public void checkOut(){
        this.occupied = false;
    }

    public void cleanRoom(){
        this.dirty = false;
    }


}