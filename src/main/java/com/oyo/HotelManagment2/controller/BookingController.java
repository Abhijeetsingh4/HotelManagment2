package com.oyo.HotelManagment2.controller;

import com.oyo.HotelManagment2.dto.response.BookingRequestDto;
import com.oyo.HotelManagment2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/")
    public void createBooking(@RequestBody BookingRequestDto bookingRequestDto){
        bookingService.createBooking(bookingRequestDto);

    }
}
