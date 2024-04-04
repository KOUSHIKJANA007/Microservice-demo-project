package com.koushik.RatingService.Service;

import com.koushik.RatingService.Entities.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> getRating();
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String hotelId);
}
