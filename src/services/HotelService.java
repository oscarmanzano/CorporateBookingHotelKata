package services;

import entities.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelService {

    List<Hotel> hotelRepository = new ArrayList<>();

    public void setRoomType(long hotelId, String roomType, int quantity) {
        Hotel hotel = findHotelById(hotelId);
        hotel.setRoomType(roomType, quantity);
    }

    public Hotel findHotelById(long hotelId) {

        Optional<Hotel> hotel = Optional.ofNullable(
                hotelRepository.stream()
                .filter(h -> h.getId() == hotelId).findFirst()
                .orElse(addNewHotel(hotelId)));

        return hotel.get();
    }

    private Hotel addNewHotel(long hotelId) {
        Hotel hotel = new Hotel(hotelId);
        hotelRepository.add(hotel);
        return hotel;
    }
}
