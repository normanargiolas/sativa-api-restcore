package com.sativachain.api.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sativachain.api.model.entity.Harvest;

@Repository
public interface IHarvestDAO extends JpaRepository <Harvest, Long> {

}
