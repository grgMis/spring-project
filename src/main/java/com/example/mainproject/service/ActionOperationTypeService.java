package com.example.mainproject.service;

import com.example.mainproject.entity.ActionOperationTypeEntity;
import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.model.ActionOperationType;
import com.example.mainproject.repository.ActionOperationTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionOperationTypeService {

    @Autowired
    private ActionOperationTypeRepo actionOperationTypeRepo;

    public List<ActionOperationTypeEntity> getAll() {
        return (List<ActionOperationTypeEntity>) actionOperationTypeRepo.findAll();
    }

    public ActionOperationType addData(ActionOperationTypeEntity actionOperationType) {
        return ActionOperationType.toModel(actionOperationTypeRepo.save(actionOperationType));
    }

    public ActionOperationType getOne(Integer id){
        ActionOperationTypeEntity actionOperationType = actionOperationTypeRepo.findById(id).get();
        return ActionOperationType.toModel(actionOperationType);
    }

    public Integer deleteOne(Integer id) {
        ActionOperationTypeEntity actionOperationType = actionOperationTypeRepo.findById(id).get();
        actionOperationTypeRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, ActionOperationTypeEntity actionOperationType) {
        ActionOperationTypeEntity entity = actionOperationTypeRepo.findById(id).get();
        entity.setAction_oper_type_name(actionOperationType.getAction_oper_type_name());
        entity.setAction_oper_type_name(actionOperationType.getAction_oper_type_name());
        actionOperationTypeRepo.save(entity);
        return id;
    }
}
