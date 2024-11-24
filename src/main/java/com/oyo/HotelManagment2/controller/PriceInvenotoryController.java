package com.oyo.HotelManagment2.controller;

import com.oyo.HotelManagment2.dto.response.PriceInventoryResponseDto;
import com.oyo.HotelManagment2.service.PriceInventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class PriceInvenotoryController {

    @Autowired
    private PriceInventoryService priceInventoryService;


    public List<PriceInventoryResponseDto> getPriceAndInvetoryForHotel(@RequestParam("hotelId") Integer hotelId, @RequestParam("checkin") LocalDate checkin) {

        log.info("THis is PriceInvenotoryController , hotelId:{}, checkin: {}", hotelId, checkin);
        return priceInventoryService.getPriceAndInvetoryForHotel(hotelId, checkin);

    }




}
