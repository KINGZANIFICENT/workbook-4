package pluralsight;

public class Reservation {

    private String roomType;
    private boolean weekend;
    private int numberOfNights;

    public Reservation(String roomType, boolean weekend, int numberOfNights) {
        this.roomType = roomType;
        this.weekend = weekend;
        this.numberOfNights = numberOfNights;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public double getPrice() {
        double baseprice = 0;

        if(roomType.equalsIgnoreCase("king")){
            baseprice = 139;
        }
        else if (roomType.equalsIgnoreCase("double")){
            baseprice = 124;
        }

        if(this.weekend){
            baseprice *= 1.10;
        }

        return baseprice;

    }

    public double getReservationTotal(){
        return getPrice() * numberOfNights;
    }
}