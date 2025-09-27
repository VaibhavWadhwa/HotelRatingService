package com.demo.rating.service.service.impl;

import com.demo.rating.service.entity.Rating;
import com.demo.rating.service.repository.RatingRepo;
import com.demo.rating.service.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepo ratingRepo;

    public RatingServiceImpl(RatingRepo ratingRepo){
        this.ratingRepo = ratingRepo;
    }

    @Override
    public Rating create(Rating rating) {
       rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
