package com.koushik.HotelService.Service;

import com.koushik.HotelService.Entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel,String hotelId);
    void deleteHotel(String hotelId);
    List<Hotel> getAllHotels();
    Hotel getHotelById(String hotelId);
}
