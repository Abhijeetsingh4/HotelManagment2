package com.oyo.HotelManagment2.repo;

import com.oyo.HotelManagment2.entity.PriceInventoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PriceInventoryRepository extends JpaRepository<PriceInventoryDetails, Integer> {


    List<PriceInventoryDetails> findByHotelIdAndDate(Integer hotelId, LocalDate checkin);
}
