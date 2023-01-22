package com.example.mainproject.service;

import com.example.mainproject.entity.ActionGroupEntity;
import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.model.ActionGroup;
import com.example.mainproject.repository.ActionGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionGroupService {

    @Autowired
    private ActionGroupRepo actionGroupRepo;

    public List<ActionGroupEntity> getAll() {
        return (List<ActionGroupEntity>) actionGroupRepo.findAll();
    }

    public ActionGroup createData(ActionGroupEntity actionGroup) {
        return ActionGroup.toModel(actionGroupRepo.save(actionGroup));
    }

    public ActionGroup getOne(Integer id) {
        ActionGroupEntity actionGroup = actionGroupRepo.findById(id).get();
        return ActionGroup.toModel(actionGroup);
    }

    public Integer deleteOne(Integer id){
        actionGroupRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, ActionGroupEntity actionGroup) {
        ActionGroupEntity entity = actionGroupRepo.findById(id).get();
        entity.setAction_group_name(actionGroup.getAction_group_name());
        entity.setAction_group_sname(actionGroup.getAction_group_sname());
        actionGroupRepo.save(entity);
        return id;
    }
}
