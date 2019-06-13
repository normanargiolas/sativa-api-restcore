package com.sativachain.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sativachain.api.model.entity.Harvest;

public interface IHarvestService {
    Harvest save(Harvest harvest);
    Page<Harvest> findAll(Pageable pageable);
    void delete(Harvest harvest);
    boolean existsById(Long harvestId);
    Optional<Harvest> findById(Long harvestId);
}
