package com.example.mainproject.service;

import com.example.mainproject.entity.*;
import com.example.mainproject.model.Equipment;
import com.example.mainproject.repository.EquipmentModelRepo;
import com.example.mainproject.repository.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private EquipmentModelRepo equipmentModelRepo;

    public List<EquipmentEntity> getAll() {
        return (List<EquipmentEntity>) equipmentRepo.findAll();
    }

    public Equipment createData(EquipmentEntity equipmentEntity, Integer id){
        EquipmentModelEntity equipmentModel = equipmentModelRepo.findById(id).get();
        equipmentEntity.setEquip_model_id(equipmentModel);
        return Equipment.toModel(equipmentRepo.save(equipmentEntity));
    }

    public Equipment getOne(Integer id) {
        EquipmentEntity equipmentEntity = equipmentRepo.findById(id).get();
        return Equipment.toModel(equipmentEntity);
    }

    public Integer deleteOne(Integer id){
        equipmentRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, EquipmentEntity equipmentEntity) {
        EquipmentEntity entity = equipmentRepo.findById(id).get();
        entity.setFactory_number(equipmentEntity.getFactory_number());
        entity.setInventory_number(equipmentEntity.getInventory_number());
        equipmentRepo.save(entity);
        return id;
    }
}
