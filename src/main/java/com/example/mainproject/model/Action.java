package com.example.mainproject.model;

import com.example.mainproject.entity.ActionEntity;
import com.example.mainproject.entity.ActionOperationEntity;
import com.example.mainproject.entity.ActionTypeEntity;
import com.example.mainproject.entity.WellEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Action {
    private Integer action_id;
    private WellEntity well_id;
    private Date action_date_begin;
    private Date action_date_end;

    private List<ActionOperation> action_oper_list;

    public static Action toModel(ActionEntity entity){
        Action model = new Action();
        model.setAction_id(entity.getAction_id());
        model.setWell_id(entity.getWell_id());
        model.setAction_date_begin(entity.getAction_date_begin());
        model.setAction_date_end(entity.getAction_date_end());
        model.setAction_oper_list(entity.getActionOperationEntityList().stream().map(ActionOperation::toModel).collect(Collectors.toList()));
        return model;
    }

    public Action() {
    }

    public List<ActionOperation> getAction_oper_list() {
        return action_oper_list;
    }

    public void setAction_oper_list(List<ActionOperation> action_oper_list) {
        this.action_oper_list = action_oper_list;
    }

    public Integer getAction_id() {
        return action_id;
    }

    public void setAction_id(Integer action_id) {
        this.action_id = action_id;
    }

    public WellEntity getWell_id() {
        return well_id;
    }

    public void setWell_id(WellEntity well_id) {
        this.well_id = well_id;
    }

    public Date getAction_date_begin() {
        return action_date_begin;
    }

    public void setAction_date_begin(Date action_date_begin) {
        this.action_date_begin = action_date_begin;
    }

    public Date getAction_date_end() {
        return action_date_end;
    }

    public void setAction_date_end(Date action_date_end) {
        this.action_date_end = action_date_end;
    }
}
