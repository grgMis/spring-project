package com.example.mainproject.service;

import com.example.mainproject.entity.*;
import com.example.mainproject.model.Equipment;
import com.example.mainproject.repository.EquipmentModelRepo;
import com.example.mainproject.repository.EquipmentRepo;
import com.example.mainproject.repository.EquipmentStateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private EquipmentModelRepo equipmentModelRepo;

    @Autowired
    private EquipmentStateRepo equipmentStateRepo;

    public List<EquipmentEntity> getAll() {
        return (List<EquipmentEntity>) equipmentRepo.findAll();
    }

    public EquipmentEntity createData(EquipmentEntity equipmentEntity, Integer idEquipModel, Integer idEquipState){
        EquipmentModelEntity equipmentModel = equipmentModelRepo.findById(idEquipModel).get();
        EquipmentStateEntity equipmentState = equipmentStateRepo.findById(idEquipState).get();
        equipmentEntity.setEquip_model_id(equipmentModel);
        equipmentEntity.setEquip_state_id(equipmentState);
        return equipmentRepo.save(equipmentEntity);
    }

    public Equipment getOne(Integer id) {
        EquipmentEntity equipmentEntity = equipmentRepo.findById(id).get();
        return Equipment.toModel(equipmentEntity);
    }

    public Integer deleteOne(Integer id){
        equipmentRepo.deleteById(id);
        return id;
    }

    public Integer updateData(EquipmentEntity equipmentEntity, Integer id, Integer idEquipState) {
        EquipmentEntity entity = equipmentRepo.findById(id).get();
        EquipmentStateEntity equipmentState = equipmentStateRepo.findById(idEquipState).get();
        entity.setFactory_number(equipmentEntity.getFactory_number());
        entity.setInventory_number(equipmentEntity.getInventory_number());
        entity.setEquip_state_id(equipmentEntity.getEquip_state_id());
        equipmentRepo.save(entity);
        return id;
    }
}
