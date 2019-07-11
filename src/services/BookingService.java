package services;

import entities.Booking;
import entities.Hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private HotelService hotelService;
    private List<Booking> bookingRepository = new ArrayList<>();

    public BookingService(HotelService hotelService, PolicyService policyService, CalendarService calendarService) {
        this.hotelService = hotelService;
    }

    public boolean book(int employeeId, int hotelId, String roomType, Object o, Object o1) {
        Hotel hotel = hotelService.findHotelById(hotelId);

        int maximumAvailableRooms = hotel.getQuantityByRoomType(roomType);

        long bookedRooms = bookingRepository.stream()
                .filter(b -> b.getHotelId() == hotelId)
                .filter(b -> b.getRoomType().equals(roomType))
                .count();

        boolean isBookingAllowed = (bookedRooms < maximumAvailableRooms);

        if (isBookingAllowed) {
            bookingRepository.add(new Booking(hotelId, roomType));
        }

        return isBookingAllowed;
    }

    public boolean validate(long hotelId, String roomType) {
       Hotel hotel = hotelService.findHotelById(hotelId);
       return hotel.hasRoomType(roomType);
    }
}
