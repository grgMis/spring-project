package com.example.mainproject.model;

import com.example.mainproject.entity.ActionGroupEntity;
import com.example.mainproject.entity.ActionTypeEntity;
import com.example.mainproject.entity.EquipmentClassEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ActionGroup {

    private Integer action_group_id;
    private String action_group_name;
    private String action_group_sname;
    private List<ActionType> action_type_list;

    public static ActionGroup toModel(ActionGroupEntity entity){
        ActionGroup model = new ActionGroup();
        model.setAction_group_id(entity.getAction_group_id());
        model.setAction_group_name(entity.getAction_group_name());
        model.setAction_group_sname(entity.getAction_group_sname());
        model.setAction_type_list(entity.getActionTypeEntitiesList().stream().map(ActionType::toModel).collect(Collectors.toList()));
        return model;
    }

    public ActionGroup() {
    }

    public Integer getAction_group_id() {
        return action_group_id;
    }

    public void setAction_group_id(Integer action_group_id) {
        this.action_group_id = action_group_id;
    }

    public String getAction_group_name() {
        return action_group_name;
    }

    public void setAction_group_name(String action_group_name) {
        this.action_group_name = action_group_name;
    }

    public String getAction_group_sname() {
        return action_group_sname;
    }

    public void setAction_group_sname(String action_group_sname) {
        this.action_group_sname = action_group_sname;
    }

    public List<ActionType> getAction_type_list() {
        return action_type_list;
    }

    public void setAction_type_list(List<ActionType> action_type_list) {
        this.action_type_list = action_type_list;
    }
}
