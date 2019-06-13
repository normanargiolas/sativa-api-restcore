package com.sativachain.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sativachain.api.model.dao.ISeedDAO;
import com.sativachain.api.model.entity.Seed;
import com.sativachain.api.service.ISeedService;

@Service
public class SeedServiceImpl implements ISeedService {

    @Autowired
    private ISeedDAO seedDAO;

    @Override
    public Page<Seed> findByHarvestId(Long postId, Pageable pageable) {
        return seedDAO.findByHarvestId(postId, pageable);
    }

    @Override
    public Optional<Seed> findByIdAndHarvestId(Long id, Long postId) {
        return seedDAO.findByIdAndHarvestId(id, postId);
    }

    @Override
    public Optional<Seed> findById(Long seedId) {
        return seedDAO.findById(seedId);
    }

    @Override
    public Object save(Seed seed) {
        return seedDAO.save(seed);
    }


    @Override
    public void delete(Object seed) {

    }
}
