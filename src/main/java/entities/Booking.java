package entities;

public class Booking {
    private long hotelId;
    private String roomType;



    private int employeeId;

    public Booking(long hotelId, String roomType, int employeeId) {
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.employeeId = employeeId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getEmployeeId() { return employeeId; }
}
