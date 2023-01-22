package com.example.mainproject.model;

import com.example.mainproject.entity.ActionEquipmentEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ActionEquipment {
    private Integer action_equip_id;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date equip_date_entry;
    private Integer equip_no;
    private float equip_depth_begin;
    private float equip_depth_end;
    private Integer equip_count;

    public static ActionEquipment toModel(ActionEquipmentEntity entity){
        ActionEquipment model = new ActionEquipment();
        model.setAction_equip_id(entity.getAction_equip_id());
        model.setEquip_date_entry(entity.getEquip_date_entry());
        model.setEquip_no(entity.getEquip_no());
        model.setEquip_depth_begin(entity.getEquip_depth_begin());
        model.setEquip_depth_end(entity.getEquip_depth_end());
        model.setEquip_count(entity.getEquip_count());
        return model;
    }
    public ActionEquipment() {
    }

    public Integer getAction_equip_id() {
        return action_equip_id;
    }

    public void setAction_equip_id(Integer action_equip_id) {
        this.action_equip_id = action_equip_id;
    }

    public Date getEquip_date_entry() {
        return equip_date_entry;
    }

    public void setEquip_date_entry(Date equip_date_entry) {
        this.equip_date_entry = equip_date_entry;
    }

    public Integer getEquip_no() {
        return equip_no;
    }

    public void setEquip_no(Integer equip_no) {
        this.equip_no = equip_no;
    }

    public float getEquip_depth_begin() {
        return equip_depth_begin;
    }

    public void setEquip_depth_begin(float equip_depth_begin) {
        this.equip_depth_begin = equip_depth_begin;
    }

    public float getEquip_depth_end() {
        return equip_depth_end;
    }

    public void setEquip_depth_end(float equip_depth_end) {
        this.equip_depth_end = equip_depth_end;
    }

    public Integer getEquip_count() {
        return equip_count;
    }

    public void setEquip_count(Integer equip_count) {
        this.equip_count = equip_count;
    }
}
