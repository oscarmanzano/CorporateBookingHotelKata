package services;

import entities.Hotel;

import java.util.ArrayList;
import java.util.List;


public class HotelService {

    List<Hotel> hotelRepository = new ArrayList<>();

    public void setRoomType(long hotelId, String roomType, int quantity) {

        Hotel hotel;

        if(isHotelInRepository(hotelId)){
            hotel = findHotelById(hotelId);
        }
        else {
            hotel = addNewHotel(hotelId);
        }

        hotel.setRoomType(roomType, quantity);
    }

    public Hotel findHotelById(long hotelId) {

        Hotel hotel = hotelRepository.stream()
                        .filter(h -> h.getId() == hotelId)
                        .findFirst().get();

        return hotel;
    }

    private Hotel addNewHotel(long hotelId) {
        Hotel hotel = new Hotel(hotelId);
        hotelRepository.add(hotel);
        return hotel;
    }

    private boolean isHotelInRepository(long hotelId){
        long count = hotelRepository.stream()
                .filter(h -> h.getId() == hotelId).count();

        return (count == 1) ? true:false;
    }
}
