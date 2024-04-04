package com.koushik.HotelService.Repository;

import com.koushik.HotelService.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}
