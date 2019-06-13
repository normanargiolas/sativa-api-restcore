package com.sativachain.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sativachain.api.model.dao.IHarvestDAO;
import com.sativachain.api.model.entity.Harvest;
import com.sativachain.api.service.IHarvestService;

@Service
public class HarvestServiceImpl implements IHarvestService {

    @Autowired
    private IHarvestDAO harvestDAO;

    @Override
    public Harvest save(Harvest harvest) {
        return harvestDAO.save(harvest);
    }

    @Override
    public Page<Harvest> findAll(Pageable pageable) {
        return harvestDAO.findAll(pageable);
    }

    @Override
    public Optional<Harvest> findById(Long harvestId) {
        return harvestDAO.findById(harvestId);
    }

    @Override
    public void delete(Harvest harvest) {
        harvestDAO.delete(harvest);
    }

    @Override
    public boolean existsById(Long harvestId) {
        return harvestDAO.existsById(harvestId);
    }
}
