package com.sativachain.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sativachain.api.exception.ResourceNotFoundException;
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

    @PutMapping("/harvests/{harvestId}")
    public Harvest updatePost(@PathVariable Long harvestId, @Valid @RequestBody Harvest harvestRequest) {
        return harvestService.findById(harvestId).map(harvest -> {
            harvest.setName(harvestRequest.getName());
            return harvestService.save(harvest);
        }).orElseThrow(() -> new ResourceNotFoundException("HarvestId " + harvestId + " not found"));
    }


    @DeleteMapping("/harvests/{harvestId}")
    public ResponseEntity<?> deleteHarvest(@PathVariable Long harvestId) {
        return harvestService.findById(harvestId).map(harvest -> {
            harvestService.delete(harvest);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("HarvestId " + harvestId + " not found"));
    }
    
}
