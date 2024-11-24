package com.oyo.HotelManagment2.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class C {


    @Autowired
    @Lazy
    private  D d;

    C(){
        log.info("This is Class C constructor");
    }

    @PostConstruct
    public void init(){
        log.info("This is C class Post Constructor");
    }
}
