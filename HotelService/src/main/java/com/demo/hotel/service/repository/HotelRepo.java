package com.demo.hotel.service.repository;

import com.demo.hotel.service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,String> {
}
