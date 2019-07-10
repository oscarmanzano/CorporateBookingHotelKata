import org.junit.Before;
import org.junit.Test;
import services.BookingService;
import services.CalendarService;
import services.PolicyService;
import services.HotelService;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class BookingFeature {

    public static final int NON_EXISTING_HOTEL_ID = 1;
    public static final int EXISTING_HOTEL_ID = 2;
    public static final String EXISTING_ROOM_TYPE = "suite";
    public static final String NON_EXISTING_ROOM_TYPE = "";
    public static final int EXISTING_EMPLOYEE_ID = 1;

    private boolean isBooked;
    private PolicyService policyService;
    private CalendarService calendarService;
    private HotelService hotelService;
    private BookingService bookingService;

    @Before
    public void setUp(){
        policyService = mock(PolicyService.class);
        calendarService = mock(CalendarService.class);

        hotelService = new HotelService();
        bookingService = new BookingService(hotelService, policyService, calendarService);

        when(policyService.isBookingAllowed(EXISTING_EMPLOYEE_ID, EXISTING_ROOM_TYPE)).thenReturn(true);
        when(calendarService.isBookingAllowed(null, null, EXISTING_ROOM_TYPE, EXISTING_HOTEL_ID)).thenReturn(true);

    }

    @Test
    public void bookingWithExistingEmployeeReturnsFalse() {

        hotelService.setRoomType(EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, 1);


        isBooked = bookingService.book(EXISTING_EMPLOYEE_ID, NON_EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, null, null);

        assertFalse(isBooked);


        isBooked = bookingService.book(EXISTING_EMPLOYEE_ID, EXISTING_HOTEL_ID, NON_EXISTING_ROOM_TYPE, null, null);

        assertFalse(isBooked);


        hotelService.setRoomType(EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, 0);

        isBooked = bookingService.book(EXISTING_EMPLOYEE_ID, EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, null, null);

        assertFalse(isBooked);

    }

    @Test
    public void bookingWithExistingEmployeeReturnsTrue() {

        hotelService.setRoomType(EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, 1);

        isBooked = bookingService.book(EXISTING_EMPLOYEE_ID, EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, null, null);

        assertTrue(isBooked);
    }
}
