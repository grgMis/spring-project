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
    private EquipmentClassRepo equipmentClassRepo;

    @Autowired
    private EquipmentModelRepo equipmentModelRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private EquipmentStateRepo equipmentStateRepo;

    public List<ActionEquipmentEntity> getAll() {
        return (List<ActionEquipmentEntity>) actionEquipmentRepo.findAll();
    }

    public ActionEquipment createData(ActionEquipmentEntity actionEquipmentEntity,
                                      Integer idActionOper,
                                      Integer idEquipClass,
                                      Integer idEquipModel,
                                      Integer idEquip,
                                      Integer idEquipState ){
        ActionOperationEntity actionOperationEntity = actionOperationRepo.findById(idActionOper).get();
        EquipmentClassEntity equipmentClass = equipmentClassRepo.findById(idEquipClass).get();
        EquipmentModelEntity equipmentModelEntity = equipmentModelRepo.findById(idEquipModel).get();
        EquipmentEntity equipmentEntity = equipmentRepo.findById(idEquip).get();
        EquipmentStateEntity equipmentState = equipmentStateRepo.findById(idEquipState).get();
        actionEquipmentEntity.setAction_oper_id(actionOperationEntity);
        actionEquipmentEntity.setEquip_class_id(equipmentClass);
        actionEquipmentEntity.setEquip_model_id(equipmentModelEntity);
        actionEquipmentEntity.setEquip_id(equipmentEntity);
        actionEquipmentEntity.setEquip_state_id(equipmentState);
        return ActionEquipment.toModel(actionEquipmentRepo.save(actionEquipmentEntity));
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
}
