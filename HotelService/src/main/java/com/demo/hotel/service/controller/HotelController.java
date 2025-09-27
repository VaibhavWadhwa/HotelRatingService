package com.demo.hotel.service.controller;

import com.demo.hotel.service.entity.Hotel;
import com.demo.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
       Hotel h = hotelService.save(hotel);
       return ResponseEntity.status(HttpStatus.CREATED).body(h);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
       List<Hotel> hotelList =  hotelService.getAll();
       return ResponseEntity.status(HttpStatus.OK).body(hotelList);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel h = hotelService.get(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(h);
    }
}
