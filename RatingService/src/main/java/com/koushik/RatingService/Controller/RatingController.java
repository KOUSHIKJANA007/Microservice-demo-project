package com.koushik.RatingService.Controller;

import com.koushik.RatingService.Entities.Rating;
import com.koushik.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping("/")
    public ResponseEntity<Rating> craeteRating(@RequestBody Rating rating){
        Rating rating1 = this.ratingService.createRating(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> getRating(){
        List<Rating> rating = this.ratingService.getRating();
        return ResponseEntity.ok(rating);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        List<Rating> ratingByUserId = this.ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratingByUserId);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        List<Rating> ratingByHotelId = this.ratingService.getRatingByUserId(hotelId);
        return ResponseEntity.ok(ratingByHotelId);
    }
}
