import entities.Hotel;
import org.junit.Test;
import services.HotelService;

import static org.junit.Assert.*;

public class HotelServiceShould {

    @Test
    public void createHotel(){

        HotelService hotelService = new HotelService();

        hotelService.setRoomType(1, "single", 1);

        Hotel hotel = hotelService.findHotelById(1);

        assertEquals(1, hotel.getId());

    }
    
}
