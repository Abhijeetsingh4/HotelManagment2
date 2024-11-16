package com.oyo.HotelManagment2.service;

import com.oyo.HotelManagment2.dto.NotificationDataDto;
import com.oyo.HotelManagment2.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Primary
@Component
public class EmailNotificationService implements NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    @Async
    public void sendNotification(NotificationDataDto notificationDataDto) {

        System.out.println(Thread.currentThread());
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setTo(notificationDataDto.getUserEMail());
//        simpleMailMessage.setText(notificationDataDto.getText());
//        simpleMailMessage.setSubject(notificationDataDto.getSubject());
//        javaMailSender.send(simpleMailMessage);

    }
}
