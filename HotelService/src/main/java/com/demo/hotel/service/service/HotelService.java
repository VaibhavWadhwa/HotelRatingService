package com.demo.hotel.service.service;

import com.demo.hotel.service.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel save(Hotel hotel);
    List<Hotel> getAll();
    Hotel get(String hotelId);
}
