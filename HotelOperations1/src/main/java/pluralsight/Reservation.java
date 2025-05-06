// Reservation.java
public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean weekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType.toLowerCase();
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType.toLowerCase();
    }

    /** Price per night based on roomType, +10% on weekends */
    public double getPrice() {
        double base = roomType.equals("king") ? 139.00 : 124.00;
        return weekend ? base * 1.10 : base;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setIsWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    /** Total = price-per-night × nights */
    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}
