package com.oyo.HotelManagment2.service;

import com.oyo.HotelManagment2.dto.NotificationDataDto;
import com.oyo.HotelManagment2.interfaces.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class WhatsAppNotificationService implements NotificationService {

    @Override
    public void sendNotification(NotificationDataDto notificationDataDto) {

        System.out.println("Send whataapp notification");

    }
}
