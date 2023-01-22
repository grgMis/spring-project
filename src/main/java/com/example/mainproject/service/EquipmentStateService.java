package com.example.mainproject.service;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentStateEntity;
import com.example.mainproject.model.EquipmentState;
import com.example.mainproject.repository.EquipmentStateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentStateService {

    @Autowired
    private EquipmentStateRepo equipmentStateRepo;

    public List<EquipmentStateEntity> getAll() {
        return (List<EquipmentStateEntity>) equipmentStateRepo.findAll();
    }

    public EquipmentState addData(EquipmentStateEntity equipmentState) {
        return EquipmentState.toModel(equipmentStateRepo.save(equipmentState));
    }

    public EquipmentState getOne(Integer id){
        EquipmentStateEntity equipmentState = equipmentStateRepo.findById(id).get();
        return EquipmentState.toModel(equipmentState);
    }

    public Integer deleteOne(Integer id) {
        EquipmentStateEntity equipmentState = equipmentStateRepo.findById(id).get();
        equipmentStateRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, EquipmentStateEntity equipmentState) {
        EquipmentStateEntity entity = equipmentStateRepo.findById(id).get();
        entity.setEquip_state_name(equipmentState.getEquip_state_name());
        entity.setEquip_state_sname(equipmentState.getEquip_state_sname());
        equipmentStateRepo.save(entity);
        return id;
    }
}
