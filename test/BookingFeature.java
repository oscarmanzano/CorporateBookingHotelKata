import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class BookingFeature {

    public static final int NON_EXISTING_HOTEL_ID = 1;
    public static final int EXISTING_HOTEL_ID = 2;
    public static final String EXISTING_ROOM_TYPE = "suite";
    public static final String NON_EXISTING_ROOM_TYPE = "";

    @Mock
    private CalendarService calendarService;

    @Mock
    private PolicyService policyService;

    private boolean isBooked;

    public void bookingWithHotelManager(){

        HotelService hotelService = new HotelService();
        BookingService bookingService = new BookingService(hotelService, policyService, calendarService);

        when(policyService.isBookingAllowed(1,EXISTING_ROOM_TYPE)).thenReturn(true);
        when(calendarService.isBookingAllowed(null,null,EXISTING_ROOM_TYPE,EXISTING_HOTEL_ID)).thenReturn(true);

        hotelService.setRoomType(EXISTING_HOTEL_ID,EXISTING_ROOM_TYPE, 1);


        isBooked = bookingService.book(1, NON_EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, null, null);

        assertFalse(isBooked);


        isBooked = bookingService.book(1, EXISTING_HOTEL_ID, NON_EXISTING_ROOM_TYPE, null, null);

        assertFalse(isBooked);


        isBooked = bookingService.book(1, EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, null, null);

        assertTrue(isBooked);


        hotelService.setRoomType(EXISTING_HOTEL_ID,EXISTING_ROOM_TYPE, 0);

        isBooked = bookingService.book(1, EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, null, null);

        assertFalse(isBooked);

    }
}
