package com.sativachain.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sativachain.api.model.entity.Seed;

public interface ISeedService {
    Page<Seed> findByHarvestId(Long postId, Pageable pageable);
    Optional<Seed> findByIdAndHarvestId(Long id, Long postId);
}
