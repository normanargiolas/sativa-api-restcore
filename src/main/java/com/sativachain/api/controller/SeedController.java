package com.sativachain.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.sativachain.api.service.ISeedService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SeedController {

    @Autowired
    private ISeedService seedService;

}
