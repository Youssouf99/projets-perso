package com.quest.etna.controllers;

import com.quest.etna.exceptions.InternalServerErrorException;
import com.quest.etna.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/testSuccess")
    public String testSuccess(){
        return "success";
    }

    @GetMapping("/testNotFound")
    public String testNotFound() throws ResourceNotFoundException {
        throw new ResourceNotFoundException("not found");
    }


    @GetMapping("/testError")
    public String testError() {
        throw new InternalServerErrorException("error");
    }



}
