package com.koushik.HotelService.Controller;

import com.koushik.HotelService.Entities.Hotel;
import com.koushik.HotelService.Payload.ApiResponse;
import com.koushik.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping("/")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = this.hotelService.createHotel(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable String hotelId){
        Hotel hotel1 = this.hotelService.updateHotel(hotel, hotelId);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<ApiResponse> deleteHotel(@PathVariable String hotelId){
        this.hotelService.deleteHotel(hotelId);
        ApiResponse apiResponse=new ApiResponse("Hotel dleted successfully",true);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel hotelById = this.hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotelById);
    }
    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotels = this.hotelService.getAllHotels();
        return ResponseEntity.ok(allHotels);
    }
}
