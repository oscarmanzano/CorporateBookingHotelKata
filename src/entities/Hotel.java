package entities;

import java.util.ArrayList;
import java.util.List;


public class Hotel {

    private long id;
    private List<Room> rooms = new ArrayList<>();

    public Hotel(long hotelId) {
        this.id = hotelId;
    }

    public long getId() {
        return this.id;
    }

    public void setRoomType(String roomType, int quantity) {
        Room room = rooms.stream()
                .filter(r -> r.getType() == roomType)
                .findFirst()
                .orElse(addRoomType(roomType, quantity));

        room.setQuantity(quantity);
    }

    private Room addRoomType(String roomType, int quantity) {
        Room room = new Room(roomType, quantity);
        rooms.add(room);
        return room;
    }
}
