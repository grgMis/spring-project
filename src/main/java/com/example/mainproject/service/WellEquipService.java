package com.example.mainproject.service;

import com.example.mainproject.entity.*;
import com.example.mainproject.repository.EquipmentRepo;
import com.example.mainproject.repository.WellEquipRepo;
import com.example.mainproject.repository.WellRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WellEquipService {

    @Autowired
    private WellRepo wellRepo;
    @Autowired
    private EquipmentRepo equipmentRepo;
    @Autowired
    private WellEquipRepo wellEquipRepo;

    public List<WellEquipEntity> getAll() {
        return (List<WellEquipEntity>) wellEquipRepo.findAll();
    }

    public WellEquipEntity createData(Integer idWell, Integer idEquipment){
        WellEquipEntity wellEquipEntity = new WellEquipEntity();
        WellEntity wellEntity = wellRepo.findById(idWell).get();
        EquipmentEntity equipmentEntity = equipmentRepo.findById(idEquipment).get();
        wellEquipEntity.setWell_id(wellEntity);
        wellEquipEntity.setEquip_id(equipmentEntity);
        return wellEquipRepo.save(wellEquipEntity);
    }

    public Integer deleteOne(Integer id){
        wellEquipRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, Integer equipId) {
        WellEquipEntity entity = wellEquipRepo.findById(id).get();
        EquipmentEntity equipmentEntity = equipmentRepo.findById(equipId).get();
        entity.setEquip_id(equipmentEntity);
        wellEquipRepo.save(entity);
        return id;
    }
}
