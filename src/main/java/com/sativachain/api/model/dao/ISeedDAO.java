package com.sativachain.api.model.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sativachain.api.model.entity.Seed;

@Repository
public interface ISeedDAO extends JpaRepository<Seed,Long> {
    Page<Seed> findByHarvestId(Long postId, Pageable pageable);
    Optional<Seed> findByIdAndHarvestId(Long id, Long postId);
}
