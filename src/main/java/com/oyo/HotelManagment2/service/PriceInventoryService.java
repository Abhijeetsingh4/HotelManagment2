package com.oyo.HotelManagment2.service;

import com.oyo.HotelManagment2.dto.response.PriceInventoryResponseDto;
import com.oyo.HotelManagment2.entity.Hotel;
import com.oyo.HotelManagment2.entity.PriceInventoryDetails;
import com.oyo.HotelManagment2.repo.PriceInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PriceInventoryService {

    @Autowired
    private PriceInventoryRepository priceInventoryRepository;

//    private  void updateInventory(){

    // write query which will decrease inventory

//    priceInventoryRepository.
//
//    }


    public List<PriceInventoryResponseDto> getAvailableHotelsByMinPrice(List<Hotel> hotelList, LocalDate checkin) {
        return null;

    }

    // checkout also requried as parameter
    public List<PriceInventoryResponseDto> getPriceAndInvetoryForHotel(Integer hotelId, LocalDate checkin) {
        List<PriceInventoryResponseDto> priceInventoryResponseDtoList = new ArrayList<>();
        List<PriceInventoryDetails> priceInventoryDetails = priceInventoryRepository.findByHotelIdAndDate(hotelId, checkin);
        for (PriceInventoryDetails priceInventoryDetail : priceInventoryDetails) {
            PriceInventoryResponseDto responseDto = convertpriceInventoryDetailsToPriceInventoryResponseDto(priceInventoryDetail);
            priceInventoryResponseDtoList.add(responseDto);

        }
        return priceInventoryResponseDtoList;

    }

    private PriceInventoryResponseDto convertpriceInventoryDetailsToPriceInventoryResponseDto(PriceInventoryDetails priceInventoryDetail) {
        Boolean isSoldOut = isHotelSoldOut(priceInventoryDetail.getAvailableRooms());
        return PriceInventoryResponseDto.builder().isSoldOut(isSoldOut).price(priceInventoryDetail.getPrice()).date(priceInventoryDetail.getDate()).build();
    }

    private Boolean isHotelSoldOut(Integer availableRooms) {
        return availableRooms < 0;

    }


}
