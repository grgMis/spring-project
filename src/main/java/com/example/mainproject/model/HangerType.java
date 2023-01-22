package com.example.mainproject.model;

import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.entity.HangerTypeEntity;

import java.util.List;
import java.util.stream.Collectors;

public class HangerType {

    private Integer hanger_type_id;
    private String hanger_type_name;
    private List<ActionOperation> action_oper_list;

    public static HangerType toModel(HangerTypeEntity entity){
        HangerType model = new HangerType();
        model.setHanger_type_id(entity.getHanger_type_id());
        model.setHanger_type_name(entity.getHanger_type_name());
        model.setAction_oper_list(entity.getActionOperationEntityList().stream().map(ActionOperation::toModel).collect(Collectors.toList()));
        return model;
    }

    public HangerType() {
    }

    public Integer getHanger_type_id() {
        return hanger_type_id;
    }

    public void setHanger_type_id(Integer hanger_type_id) {
        this.hanger_type_id = hanger_type_id;
    }

    public String getHanger_type_name() {
        return hanger_type_name;
    }

    public void setHanger_type_name(String hanger_type_name) {
        this.hanger_type_name = hanger_type_name;
    }

    public List<ActionOperation> getAction_oper_list() {
        return action_oper_list;
    }

    public void setAction_oper_list(List<ActionOperation> action_oper_list) {
        this.action_oper_list = action_oper_list;
    }
}
