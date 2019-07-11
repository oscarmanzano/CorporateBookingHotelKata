package entities;

public class Room {

    private String roomType;

    public int getQuantity() {
        return quantity;
    }

    private int quantity;

    public Room(String roomType, int quantity) {
        this.roomType = roomType;
        this.quantity = quantity;
    }

    public String getType() {
        return this.roomType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
