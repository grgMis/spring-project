package com.example.mainproject.service;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentCategoryEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.model.EquipmentClass;
import com.example.mainproject.repository.EquipmentCategoryRepo;
import com.example.mainproject.repository.EquipmentClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentClassService {

    @Autowired
    private EquipmentClassRepo equipmentClassRepo;

    @Autowired
    private EquipmentCategoryRepo equipmentCategoryRepo;

    public List<EquipmentClassEntity> getAll() {
        return (List<EquipmentClassEntity>) equipmentClassRepo.findAll();
    }

    public EquipmentClass createData(EquipmentClassEntity equipmentClass, Integer id){
        EquipmentCategoryEntity equipmentCategory = equipmentCategoryRepo.findById(id).get();
        equipmentClass.setEquip_category_id(equipmentCategory);
        return EquipmentClass.toModel(equipmentClassRepo.save(equipmentClass));
    }

    public EquipmentClass getOne(Integer id) {
        EquipmentClassEntity equipmentClass = equipmentClassRepo.findById(id).get();
        return EquipmentClass.toModel(equipmentClass);
    }

    public Integer deleteOne(Integer id){
        equipmentClassRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, EquipmentClassEntity equipmentClass) {
        EquipmentClassEntity entity = equipmentClassRepo.findById(id).get();
        entity.setEquip_class_name(equipmentClass.getEquip_class_name());
        entity.setEquip_class_sname(equipmentClass.getEquip_class_sname());
        equipmentClassRepo.save(entity);
        return id;
    }
}
