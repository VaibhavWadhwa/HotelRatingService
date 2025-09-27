package com.demo.hotel.service.service.impl;

import com.demo.hotel.service.entity.Hotel;
import com.demo.hotel.service.exception.ResourceNotFoundException;
import com.demo.hotel.service.repository.HotelRepo;
import com.demo.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepo hotelRepo;

    @Autowired
    public HotelServiceImpl(HotelRepo hotelRepo){
        this.hotelRepo = hotelRepo;
    }

    @Override
    public Hotel save(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel get(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with id "+hotelId + " is not found."));
    }
}
