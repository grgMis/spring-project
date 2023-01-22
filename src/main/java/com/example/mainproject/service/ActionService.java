package com.example.mainproject.service;

import com.example.mainproject.entity.*;
import com.example.mainproject.repository.ActionRepo;
import com.example.mainproject.repository.ActionTypeRepo;
import com.example.mainproject.repository.WellRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ActionService {

    @Autowired
    private ActionRepo actionRepo;

    @Autowired
    private WellRepo wellRepo;

    @Autowired
    private ActionTypeRepo actionTypeRepo;

    public List<ActionEntity> getAll() {
        return (List<ActionEntity>) actionRepo.findAll();
    }

    public ActionEntity createData(ActionEntity actionEntity, Integer idWell, Integer idActionType){
        WellEntity wellEntity = wellRepo.findById(idWell).get();
        ActionTypeEntity actionType = actionTypeRepo.findById(idActionType).get();
        actionEntity.setWell_id(wellEntity);
        actionEntity.setAction_type_id(actionType);
        return actionRepo.save(actionEntity);
    }

    public ActionEntity getOne(Integer id) {
        ActionEntity actionEntity = actionRepo.findById(id).get();
        return actionEntity;
    }

    public Integer deleteOne(Integer id){
        actionRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, ActionEntity actionEntity) {
        ActionEntity entity = actionRepo.findById(id).get();
        entity.setAction_date_begin(actionEntity.getAction_date_begin());
        entity.setAction_date_end(actionEntity.getAction_date_end());
        actionRepo.save(entity);
        return id;
    }
}
