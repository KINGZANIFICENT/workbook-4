package pluralsight;

// RoomTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void testCheckInSuccess() {
        Room room = new Room(1, 100.0, false, false);
        room.checkIn();
        assertTrue(room.isOccupied(), "Room should be occupied after checkIn");
        assertTrue(room.isDirty(), "Room should be dirty after checkIn");
    }

    @Test
    public void testCheckInWhenOccupiedThrows() {
        Room room = new Room(1, 100.0, true, false);
        assertThrows(IllegalStateException.class, room::checkIn,
                "Checking in an already occupied room should throw");
    }

    @Test
    public void testCheckInWhenDirtyThrows() {
        Room room = new Room(1, 100.0, false, true);
        assertThrows(IllegalStateException.class, room::checkIn,
                "Checking in a dirty room should throw");
    }

    @Test
    public void testCheckOutSuccess() {
        Room room = new Room(1, 100.0, true, true);
        room.checkOut();
        assertFalse(room.isOccupied(), "Room should not be occupied after checkOut");
        assertTrue(room.isDirty(), "Room should remain dirty after checkOut");
    }

    @Test
    public void testCheckOutWhenNotOccupiedThrows() {
        Room room = new Room(1, 100.0, false, true);
        assertThrows(IllegalStateException.class, room::checkOut,
                "Checking out a non-occupied room should throw");
    }

    @Test
    public void testCleanRoomSuccess() {
        Room room = new Room(1, 100.0, false, true);
        room.cleanRoom();
        assertFalse(room.isDirty(), "Room should be clean after cleanRoom");
    }

    @Test
    public void testCleanRoomWhenOccupiedThrows() {
        Room room = new Room(1, 100.0, true, true);
        assertThrows(IllegalStateException.class, room::cleanRoom,
                "Cleaning an occupied room should throw");
    }
}
