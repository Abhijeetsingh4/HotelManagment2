package com.oyo.HotelManagment2.controller;

import com.oyo.HotelManagment2.Annotations.Log;
import com.oyo.HotelManagment2.Exception.HotelNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.oyo.HotelManagment2.dto.request.HotelRequestDto;
import com.oyo.HotelManagment2.dto.response.HotelResponseDto;
import com.oyo.HotelManagment2.service.HotelService;

@Slf4j
@RequestMapping("/api/v1/hotel")
@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;


    //get ALl hotels By location

//    @Log
    @PostMapping("/create")
    public ResponseEntity<Boolean> createHotel(@RequestBody HotelRequestDto hotelRequestDto) {
        Boolean success = hotelService.createHotel(hotelRequestDto);
        log.info("request sent by customer:{}", hotelRequestDto.getHotelName());

        return new ResponseEntity<>(success, HttpStatus.CREATED);

    }

    @Log
    @GetMapping("/")
    public ResponseEntity<HotelResponseDto> getHotelDetails(@RequestParam Integer hotelId) {

        try {
            HotelResponseDto hotelResponseDto = hotelService.getHotelDetails(hotelId);
            log.info("Hotel request came to system for hotelId:{}", hotelId);
            return new ResponseEntity<>(hotelResponseDto, HttpStatus.OK);

        } catch (HotelNotFoundException e) {
            log.error("Error occured while getting data for hotelId: {}", hotelId);
            HotelResponseDto hotelResponseDto = new HotelResponseDto();
            hotelResponseDto.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(hotelResponseDto, HttpStatus.BAD_REQUEST);

        }


    }


}
