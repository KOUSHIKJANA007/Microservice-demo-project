package com.koushik.HotelService.Service.Impl;

import com.koushik.HotelService.Entities.Hotel;
import com.koushik.HotelService.Exception.ResourceNotFoundException;
import com.koushik.HotelService.Repository.HotelRepo;
import com.koushik.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String id= UUID.randomUUID().toString();
        hotel.setId(id);
        return this.hotelRepo.save(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel,String hotelId) {
        Hotel hotel1 = this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found at id " + hotelId));
        hotel1.setName(hotel.getName());
        hotel1.setAbout(hotel.getAbout());
        hotel1.setLocation(hotel.getLocation());
        return this.hotelRepo.save(hotel1);
    }

    @Override
    public void deleteHotel(String hotelId) {
        Hotel hotel = this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found at id " + hotelId));
        this.hotelRepo.delete(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return this.hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return this.hotelRepo.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel not found at id "+hotelId));
    }
}
