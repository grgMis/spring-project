package com.example.mainproject.repository;

import com.example.mainproject.entity.EquipmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepo extends CrudRepository<EquipmentEntity, Integer> {
}
