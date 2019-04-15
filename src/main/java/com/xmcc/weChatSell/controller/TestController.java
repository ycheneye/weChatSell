package com.xmcc.weChatSell.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/hello")
    public String test(){
        log.info("hello springBoot");
        return "hello springBoot";
    }
}
