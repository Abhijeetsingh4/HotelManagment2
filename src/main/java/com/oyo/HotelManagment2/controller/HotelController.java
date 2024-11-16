package com.oyo.HotelManagment2.controller;

import com.oyo.HotelManagment2.Exception.HotelNotFoundException;
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

@RequestMapping("/api/v1/hotel")
@RestController
public class HotelController {

  @Autowired
  private HotelService hotelService;


  //get ALl hotels By location

  @PostMapping("/create")
  public ResponseEntity<Boolean> createHotel(@RequestBody HotelRequestDto hotelRequestDto){
    Boolean success= hotelService.createHotel(hotelRequestDto);

    return  new ResponseEntity<>(success, HttpStatus.CREATED);

  }



  @GetMapping("/")
  public ResponseEntity<HotelResponseDto> getHotelDetails(@RequestParam Integer hotelId)  {

    try{
      HotelResponseDto hotelResponseDto=  hotelService.getHotelDetails(hotelId);
      return new ResponseEntity<>(hotelResponseDto,HttpStatus.OK);

    }
    catch (HotelNotFoundException e){
      HotelResponseDto  hotelResponseDto = new HotelResponseDto();
      hotelResponseDto.setErrorMessage(e.getMessage());
      return new ResponseEntity<>(hotelResponseDto,HttpStatus.BAD_REQUEST);

    }


  }




}
