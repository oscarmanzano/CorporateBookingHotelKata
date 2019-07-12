import entities.Hotel;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HotelShould {

    //SetRoomType
    //AddRoomType
    //HasRoomType
    //getQuantityByRoomType
    Hotel hotel;

    @Before
    public void setup(){

        hotel = new Hotel(1);
    }

    @Test
    public void addRooms(){

        hotel.setRoomType("single", 1);

        assertEquals(1, hotel.getQuantityByRoomType("single"));
    }

    @Test
    public void updateRoomsQuantity(){

        hotel.setRoomType("single", 1);
        hotel.setRoomType("single", 2);

        assertEquals(2, hotel.getQuantityByRoomType("single"));
    }

    @Test
    public void verifyExistOfRoomType(){

        hotel.setRoomType("single", 1);
        assertTrue(hotel.hasRoomType("single"));
    }

}
