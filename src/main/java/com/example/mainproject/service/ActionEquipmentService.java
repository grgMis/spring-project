package com.example.mainproject.service;

import com.example.mainproject.entity.*;
import com.example.mainproject.model.ActionEquipment;
import com.example.mainproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionEquipmentService {

    @Autowired
    private ActionEquipmentRepo actionEquipmentRepo;

    @Autowired
    private ActionOperationRepo actionOperationRepo;
    @Autowired
    private WellEquipRepo wellEquipRepo;

    public List<ActionEquipmentEntity> getAll() {
        return (List<ActionEquipmentEntity>) actionEquipmentRepo.findAll();
    }

    public ActionEquipmentEntity addData(ActionEquipmentEntity actionEquipmentEntity,
                                      Integer idActionOper,
                                      Integer idWellEquip){
        ActionOperationEntity actionOperationEntity = actionOperationRepo.findById(idActionOper).get();
        WellEquipEntity wellEquipEntity = wellEquipRepo.findById(idWellEquip).get();
        actionEquipmentEntity.setAction_oper_id(actionOperationEntity);
        actionEquipmentEntity.setWell_equip_id(wellEquipEntity);
        return actionEquipmentRepo.save(actionEquipmentEntity);
    }

    public ActionEquipment getOne(Integer id) {
        ActionEquipmentEntity actionEquipmentEntity = actionEquipmentRepo.findById(id).get();
        return ActionEquipment.toModel(actionEquipmentEntity);
    }

    public Integer deleteOne(Integer id){
        actionEquipmentRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, ActionEquipmentEntity actionEquipmentEntity) {
        ActionEquipmentEntity entity = actionEquipmentRepo.findById(id).get();
        entity.setEquip_date_entry(actionEquipmentEntity.getEquip_date_entry());
        entity.setEquip_no(actionEquipmentEntity.getEquip_no());
        entity.setEquip_depth_begin(actionEquipmentEntity.getEquip_depth_begin());
        entity.setEquip_depth_end(actionEquipmentEntity.getEquip_depth_end());
        entity.setEquip_count(actionEquipmentEntity.getEquip_count());
        actionEquipmentRepo.save(entity);
        return id;
    }

    public Integer updateEquipState(Integer id) {
        ActionEquipmentEntity entity = actionEquipmentRepo.findById(id).get();
        actionEquipmentRepo.save(entity);
        return id;
    }
}
