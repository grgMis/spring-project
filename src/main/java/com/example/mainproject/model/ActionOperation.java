package com.example.mainproject.model;

import com.example.mainproject.entity.ActionGroupEntity;
import com.example.mainproject.entity.ActionOperationEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ActionOperation {
    private Integer action_oper_id;
    private Date action_oper_date;
    private List<ActionEquipment> action_equip_list;

    public static ActionOperation toModel(ActionOperationEntity entity){
        ActionOperation model = new ActionOperation();
        model.setAction_oper_id(entity.getAction_oper_id());
        model.setAction_oper_date(entity.getAction_oper_date());
        model.setAction_equip_list(entity.getActionEquipmentEntityList().stream().map(ActionEquipment::toModel).collect(Collectors.toList()));
        return model;
    }

    public ActionOperation() {
    }

    public Integer getAction_oper_id() {
        return action_oper_id;
    }

    public void setAction_oper_id(Integer action_oper_id) {
        this.action_oper_id = action_oper_id;
    }

    public Date getAction_oper_date() {
        return action_oper_date;
    }

    public void setAction_oper_date(Date action_oper_date) {
        this.action_oper_date = action_oper_date;
    }

    public List<ActionEquipment> getAction_equip_list() {
        return action_equip_list;
    }

    public void setAction_equip_list(List<ActionEquipment> action_equip_list) {
        this.action_equip_list = action_equip_list;
    }
}
