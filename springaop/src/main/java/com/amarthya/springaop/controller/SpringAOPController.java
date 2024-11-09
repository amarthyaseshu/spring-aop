package com.amarthya.springaop.controller;

import com.amarthya.springaop.service.SpringAOPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAOPController {

    @Autowired
    private SpringAOPService springAOPService;

    @GetMapping("/getData")
    public String getData(){
        return  springAOPService.getDataService();
    }

    @GetMapping("/getData1")
    public String getData1(){
        return  springAOPService.getDataService();
    }

    @GetMapping("/getData2")
    public String getData2(){
       throw new RuntimeException();
    }
}
