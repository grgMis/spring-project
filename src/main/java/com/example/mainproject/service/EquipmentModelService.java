package com.example.mainproject.service;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentCategoryEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.entity.EquipmentModelEntity;
import com.example.mainproject.model.EquipmentModel;
import com.example.mainproject.repository.EquipmentClassRepo;
import com.example.mainproject.repository.EquipmentModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentModelService {

    @Autowired
    private EquipmentModelRepo equipmentModelRepo;

    @Autowired
    private EquipmentClassRepo equipmentClassRepo;

    public List<EquipmentModelEntity> getAll() {
        return (List<EquipmentModelEntity>) equipmentModelRepo.findAll();
    }

    public EquipmentModel createData(EquipmentModelEntity equipmentModel, Integer id){
        EquipmentClassEntity equipmentClass = equipmentClassRepo.findById(id).get();
        equipmentModel.setEquip_class_id(equipmentClass);
        return EquipmentModel.toModel(equipmentModelRepo.save(equipmentModel));
    }

    public EquipmentModel getOne(Integer id) {
        EquipmentModelEntity equipmentModel = equipmentModelRepo.findById(id).get();
        return EquipmentModel.toModel(equipmentModel);
    }

    public Integer deleteOne(Integer id){
        equipmentModelRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, EquipmentModelEntity equipmentModel) {
        EquipmentModelEntity entity = equipmentModelRepo.findById(id).get();
        entity.setEquip_model_name(equipmentModel.getEquip_model_name());
        entity.setEquip_model_sname(equipmentModel.getEquip_model_sname());
        equipmentModelRepo.save(entity);
        return id;
    }
}
