package com.example.mainproject.service;

import com.example.mainproject.entity.ActionGroupEntity;
import com.example.mainproject.entity.ActionTypeEntity;
import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.repository.ActionGroupRepo;
import com.example.mainproject.repository.ActionTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionTypeService {

    @Autowired
    private ActionTypeRepo actionTypeRepo;

    @Autowired
    private ActionGroupRepo actionGroupRepo;

    public List<ActionTypeEntity> getAll() {
        return (List<ActionTypeEntity>) actionTypeRepo.findAll();
    }

    public ActionTypeEntity createData(ActionTypeEntity actionType, Integer id){
        ActionGroupEntity actionGroup = actionGroupRepo.findById(id).get();
        actionType.setAction_group_id(actionGroup);
        return actionTypeRepo.save(actionType);
    }

    public ActionTypeEntity getOne(Integer id) {
        ActionTypeEntity actionType = actionTypeRepo.findById(id).get();
        return actionType;
    }

    public Integer deleteOne(Integer id){
        actionTypeRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, ActionTypeEntity actionType) {
        ActionTypeEntity entity = actionTypeRepo.findById(id).get();
        entity.setAction_type_name(actionType.getAction_type_name());
        entity.setAction_type_sname(actionType.getAction_type_sname());
        actionTypeRepo.save(entity);
        return id;
    }
}
