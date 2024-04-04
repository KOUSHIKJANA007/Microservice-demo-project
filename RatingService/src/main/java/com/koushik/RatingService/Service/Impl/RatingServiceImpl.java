package com.koushik.RatingService.Service.Impl;

import com.koushik.RatingService.Entities.Rating;
import com.koushik.RatingService.Repository.RatingRepo;
import com.koushik.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating createRating(Rating rating) {
        return this.ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRating() {
        return this.ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return this.ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return this.ratingRepo.findByHotelId(hotelId);
    }
}
