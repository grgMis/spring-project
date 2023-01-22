package com.example.mainproject.service;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentCategoryEntity;
import com.example.mainproject.model.EquipmentCategory;
import com.example.mainproject.repository.EquipmentCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentCategoryService {

    @Autowired
    private EquipmentCategoryRepo equipmentCategoryRepo;

    public List<EquipmentCategoryEntity> getAll() {
        return (List<EquipmentCategoryEntity>) equipmentCategoryRepo.findAll();
    }

    public EquipmentCategory createData(EquipmentCategoryEntity equipmentCategory) {
        return EquipmentCategory.toModel(equipmentCategoryRepo.save(equipmentCategory));
    }

    public EquipmentCategory getOne(Integer id) {
        EquipmentCategoryEntity equipmentCategory = equipmentCategoryRepo.findById(id).get();
        return EquipmentCategory.toModel(equipmentCategory);
    }

    public Integer deleteOne(Integer id){
        equipmentCategoryRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, EquipmentCategoryEntity equipmentCategory) {
        EquipmentCategoryEntity entity = equipmentCategoryRepo.findById(id).get();
        entity.setEquip_category_name(equipmentCategory.getEquip_category_name());
        entity.setEquip_category_sname(equipmentCategory.getEquip_category_sname());
        equipmentCategoryRepo.save(entity);
        return id;
    }
}
