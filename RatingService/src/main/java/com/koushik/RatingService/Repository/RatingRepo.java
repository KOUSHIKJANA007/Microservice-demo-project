package com.koushik.RatingService.Repository;

import com.koushik.RatingService.Entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository<Rating,String> {
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
