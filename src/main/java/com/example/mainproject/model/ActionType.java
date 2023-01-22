package com.example.mainproject.model;

import com.example.mainproject.entity.ActionGroupEntity;
import com.example.mainproject.entity.ActionTypeEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ActionType {
    private Integer action_type_id;
    private String action_type_name;
    private String action_type_sname;
    private List<Action> action_list;

    public static ActionType toModel(ActionTypeEntity entity){
        ActionType model = new ActionType();
        model.setAction_type_id(entity.getAction_type_id());
        model.setAction_type_name(entity.getAction_type_name());
        model.setAction_type_sname(entity.getAction_type_sname());
        model.setAction_list(entity.getActionEntityList().stream().map(Action::toModel).collect(Collectors.toList()));
        return model;
    }

    public ActionType() {
    }

    public Integer getAction_type_id() {
        return action_type_id;
    }

    public void setAction_type_id(Integer action_type_id) {
        this.action_type_id = action_type_id;
    }

    public String getAction_type_name() {
        return action_type_name;
    }

    public void setAction_type_name(String action_type_name) {
        this.action_type_name = action_type_name;
    }

    public String getAction_type_sname() {
        return action_type_sname;
    }

    public void setAction_type_sname(String action_type_sname) {
        this.action_type_sname = action_type_sname;
    }

    public List<Action> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<Action> action_list) {
        this.action_list = action_list;
    }
}
