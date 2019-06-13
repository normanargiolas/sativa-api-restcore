package com.sativachain.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sativachain.api.model.entity.Harvest;
import com.sativachain.api.service.IHarvestService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HarvestController {

    @Autowired
    private IHarvestService harvestService;

    @GetMapping("/api/harvests")
    public Page<Harvest> getAllHarvests(Pageable pageable) {
        return harvestService.findAll(pageable);
    }

    @PostMapping("/api/harvests")
    public Harvest createHarvest(@Valid @RequestBody Harvest harvest) {
        return harvestService.save(harvest);
    }
}
