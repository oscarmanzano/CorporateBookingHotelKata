import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import services.*;


public class BookingServiceShould {
    public static final int EXISTING_HOTEL_ID = 2;
    public static final String EXISTING_ROOM_TYPE = "suite";
    public static final String NON_EXISTING_ROOM_TYPE = "";
    public static final int EXISTING_EMPLOYEE_ID = 1;
    private HotelService hotelService;
    private PolicyService policyService;
    private BookingService bookingService;
    private CompanyService companyService;


    @Before
    public void setUp() {
        hotelService = new HotelService();
        companyService = new CompanyService();
        policyService = mock(PolicyService.class);
        CalendarService calendarService = mock(CalendarService.class);
        when(policyService.isBookingAllowed(EXISTING_EMPLOYEE_ID, EXISTING_ROOM_TYPE)).thenReturn(true);
        when(calendarService.isBookingAllowed(null, null, EXISTING_ROOM_TYPE, EXISTING_HOTEL_ID)).thenReturn(true);
        bookingService = new BookingService(hotelService, policyService, calendarService, companyService);
    }

    @Test
    public void validateHotelAndRoomTypeReturnFalse(){

        hotelService.setRoomType(EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, 1);

        boolean validated = bookingService.validate(EXISTING_HOTEL_ID, NON_EXISTING_ROOM_TYPE);

        assertFalse(validated);
    }

    @Test
    public void validateHotelAndRoomTypeReturnTrue(){
        hotelService.setRoomType(EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE, 1);

        boolean validated = bookingService.validate(EXISTING_HOTEL_ID, EXISTING_ROOM_TYPE);

        assertTrue(validated);
    }

    @Test
    public void bookingNotAvailableRoomReturnFalse(){
        hotelService.setRoomType(1, "double", 5);

        boolean booked;

        booked = bookingService.book(1, 1, "double", null, null);
        booked = bookingService.book(1, 1, "double", null, null);
        booked = bookingService.book(1, 1, "double", null, null);
        booked = bookingService.book(1, 1, "double", null, null);
        booked = bookingService.book(1, 1, "double", null, null);
        booked = bookingService.book(1, 1, "double", null, null);

        assertFalse(booked);
    }

}
