package entities;

public class Hotel {

    private long id;

    public Hotel(long hotelId) {
        this.id = hotelId;
    }

    public long getId() {
        return this.id;
    }

    public void setRoomType(String roomType, int quantity) {
    }
}
