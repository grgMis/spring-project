package com.example.mainproject.repository;

import com.example.mainproject.entity.EquipmentStateEntity;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentStateRepo extends CrudRepository<EquipmentStateEntity, Integer> {
}
