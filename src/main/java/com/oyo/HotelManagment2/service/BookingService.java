package com.oyo.HotelManagment2.service;

import com.oyo.HotelManagment2.dto.NotificationDataDto;
import com.oyo.HotelManagment2.dto.request.BookingResponseDto;
import com.oyo.HotelManagment2.dto.response.BookingRequestDto;
import com.oyo.HotelManagment2.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BookingService {

//    @Autowired
//    BookingRepo bookingRepo;

    @Autowired
    private NotificationService notificationService;


    @Autowired
    private PriceInventoryService priceInventoryService;


    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {

        // validate request
        // inventory available or not? and get inventory priceInventoryService.checkAvailability()
        // create with status -> CREATED // bookingRepo.save(booking);
        // update Inventory // priceInventoryService.updateInventory();
        // return booking response

//        -------------------------
        System.out.println(Thread.currentThread());
        NotificationDataDto notificationDataDto = getNotificationSenderDto();
        notificationService.sendNotification(notificationDataDto);
        System.out.println(Thread.currentThread());
        System.out.println("Booking Completed");

        return null;

    }

    private NotificationDataDto getNotificationSenderDto() {
        NotificationDataDto notificationDataDto = new NotificationDataDto();
        notificationDataDto.setText("Booking Confimed");
        notificationDataDto.setUserEMail("shubham.raghav.23699@gmai.com");
        notificationDataDto.setSubject("BOOKING CONFIRMED!");
        return notificationDataDto;

    }

    public Boolean cancelBooking(Integer bookingId) {
        // validate if booking is not in cancelled state  and is present in our database
        // status -> CANCCLLED // bookingRepo.save();
        // increase inventory // priceInventoryService.updateInventory();
        return true;
    }

    public BookingResponseDto getBooking(Integer bookingId) {
        // findById
        return null;
    }


}
