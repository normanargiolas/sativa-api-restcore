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
import com.sativachain.api.model.entity.Seed;
import com.sativachain.api.service.IHarvestService;
import com.sativachain.api.service.ISeedService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SeedController {

    @Autowired
    private ISeedService seedService;

    @Autowired
    private IHarvestService harvestService;

    @GetMapping("/harvests/{harvestId}/seeds")
    public Page<Seed> getAllSeedsByHarvestId(@PathVariable(value = "harvestId") Long harvestId,
                                             Pageable pageable) {
        return seedService.findByHarvestId(harvestId, pageable);
    }

    @PostMapping("/harvests/{harvestId}/seeds")
    public Seed createSeed(@PathVariable(value = "harvestId") Long harvestId,
                           @Valid @RequestBody Seed seed) {
        return (Seed) harvestService.findById(harvestId).map(harvest -> {
            seed.setHarvest(harvest);
            return seedService.save(seed);
        }).orElseThrow(() -> new ResourceNotFoundException("HarvestId " + harvestId + " not found"));
    }

    @PutMapping("/harvests/{harvestId}/seeds/{seedId}")
    public Seed updateSeed(@PathVariable(value = "harvestId") Long harvestId,
                           @PathVariable(value = "seedId") Long seedId,
                           @Valid @RequestBody Seed seedRequest) {
        if (!harvestService.existsById(harvestId)) {
            throw new ResourceNotFoundException("HarvestId " + harvestId + " not found");
        }

        return (Seed) seedService.findById(seedId).map(seed -> {
            seed.setCode(seedRequest.getCode());
            seed.setSpecies(seedRequest.getSpecies());
            seed.setVariety(seedRequest.getVariety());
            seed.setOrigin(seedRequest.getOrigin());

            return seedService.save(seed);
        }).orElseThrow(() -> new ResourceNotFoundException("SeedId " + seedId + "not found"));
    }

    @DeleteMapping("/harvests/{harvestId}/seeds/{seedId}")
    public ResponseEntity<?> deleteSeed(@PathVariable(value = "harvestId") Long harvestId,
                                        @PathVariable(value = "seedId") Long seedId) {
        return seedService.findByIdAndHarvestId(seedId, harvestId).map(seed -> {
            seedService.delete(seed);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Seed not found with id " + seedId + " and harvestId " + harvestId));
    }

}
