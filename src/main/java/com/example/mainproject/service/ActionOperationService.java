package com.example.mainproject.service;

import com.example.mainproject.entity.*;
import com.example.mainproject.model.ActionOperation;
import com.example.mainproject.repository.ActionOperationRepo;
import com.example.mainproject.repository.ActionOperationTypeRepo;
import com.example.mainproject.repository.ActionRepo;
import com.example.mainproject.repository.HangerTypeRepo;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionOperationService {

    @Autowired
    private ActionOperationRepo actionOperationRepo;

    @Autowired
    private ActionRepo actionRepo;

    @Autowired
    private ActionOperationTypeRepo actionOperationTypeRepo;

    @Autowired
    private HangerTypeRepo hangerTypeRepo;

    public List<ActionOperationEntity> getAll() {
        return (List<ActionOperationEntity>) actionOperationRepo.findAll();
    }

    public ActionOperation createData(ActionOperationEntity actionOperationEntity,
                                            Integer idAction,
                                            Integer idActionOperType,
                                            Integer idHangerType ){
        ActionEntity actionEntity = actionRepo.findById(idAction).get();
        ActionOperationTypeEntity actionOperationTypeEntity = actionOperationTypeRepo.findById(idActionOperType).get();
        HangerTypeEntity hangerTypeEntity = hangerTypeRepo.findById(idHangerType).get();
        actionOperationEntity.setAction_id(actionEntity);
        actionOperationEntity.setAction_oper_type_id(actionOperationTypeEntity);
        actionOperationEntity.setHanger_type_id(hangerTypeEntity);
        return ActionOperation.toModel(actionOperationRepo.save(actionOperationEntity));
    }

    public ActionOperation getOne(Integer id) {
        ActionOperationEntity actionOperationEntity = actionOperationRepo.findById(id).get();
        return ActionOperation.toModel(actionOperationEntity);
    }

    public Integer deleteOne(Integer id){
        actionOperationRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, ActionOperationEntity actionOperationEntity) {
        ActionOperationEntity entity = actionOperationRepo.findById(id).get();
        entity.setAction_oper_date(actionOperationEntity.getAction_oper_date());
        actionOperationRepo.save(entity);
        return id;
    }
}
