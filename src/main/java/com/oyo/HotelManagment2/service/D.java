package com.oyo.HotelManagment2.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class D {

    @Autowired
    private B b;


    public D(){
        log.info("This is D class Constructor");
    }

    @PostConstruct
    public void init(){
        log.info("This is D class Post Constructor");
    }

    @PreDestroy
    public void preDestroy()
    {
        log.info("pre Destory bean");
    }


}
