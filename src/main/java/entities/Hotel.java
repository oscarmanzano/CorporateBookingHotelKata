package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
                .filter(r -> r.getType().equals(roomType))
                .findFirst()
                .orElse(addRoomType(roomType, quantity));

        room.setQuantity(quantity);
    }

    private Room addRoomType(String roomType, int quantity) {
        Room room = new Room(roomType, quantity);
        rooms.add(room);
        return room;
    }

    public boolean hasRoomType(String roomType){
        Optional<Room> room = rooms.stream().filter(r -> r.getType().equals(roomType)).findAny();
        return room.isPresent();
    }

    public int getQuantityByRoomType(String roomType) {

        Optional<Room> optionalRoom = Optional.of(rooms.stream()
                .filter(r -> r.getType().equals(roomType))
                .findFirst())
                .orElse(null);

        return optionalRoom.map(Room::getQuantity).orElse(0);
    }
}
