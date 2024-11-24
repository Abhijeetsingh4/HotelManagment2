package com.oyo.HotelManagment2.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class B {

    @Autowired
    public C C;

    public B(){
        log.info("This is Class B constructor");
    }


    @PostConstruct
    public void init(){
        log.info("This is B class Post Constructor");
    }
}
