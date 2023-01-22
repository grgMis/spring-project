package com.example.mainproject.model;

import com.example.mainproject.entity.ActionOperationTypeEntity;
import com.example.mainproject.entity.EquipmentModelEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ActionOperationType {

    private Integer action_oper_type_id;
    private String action_oper_type_name;
    private String action_oper_type_sname;
    private List<ActionOperation> action_oper_list;

    public static ActionOperationType toModel(ActionOperationTypeEntity entity){
        ActionOperationType model = new ActionOperationType();
        model.setAction_oper_type_id(entity.getAction_oper_type_id());
        model.setAction_oper_type_name(entity.getAction_oper_type_name());
        model.setAction_oper_type_sname(entity.getAction_oper_type_sname());
        model.setAction_oper_list(entity.getActionOperationEntityList().stream().map(ActionOperation::toModel).collect(Collectors.toList()));
        return model;
    }

    public ActionOperationType() {
    }

    public Integer getAction_oper_type_id() {
        return action_oper_type_id;
    }

    public void setAction_oper_type_id(Integer action_oper_type_id) {
        this.action_oper_type_id = action_oper_type_id;
    }

    public String getAction_oper_type_name() {
        return action_oper_type_name;
    }

    public void setAction_oper_type_name(String action_oper_type_name) {
        this.action_oper_type_name = action_oper_type_name;
    }

    public String getAction_oper_type_sname() {
        return action_oper_type_sname;
    }

    public void setAction_oper_type_sname(String action_oper_type_sname) {
        this.action_oper_type_sname = action_oper_type_sname;
    }

    public List<ActionOperation> getAction_oper_list() {
        return action_oper_list;
    }

    public void setAction_oper_list(List<ActionOperation> action_oper_list) {
        this.action_oper_list = action_oper_list;
    }
}
