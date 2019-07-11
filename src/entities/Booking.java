package entities;

public class Booking {
    private long hotelId;
    private String roomType;

    public Booking(long hotelId, String roomType) {
        this.hotelId = hotelId;
        this.roomType = roomType;
    }

    public long getHotelId() {
        return hotelId;
    }

    public String getRoomType() {
        return roomType;
    }
}
