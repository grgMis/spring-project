package com.example.mainproject.model;

import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.entity.EquipmentStateEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EquipmentState {

    private Integer equip_state_id;
    private String equip_state_name;
    private String equip_state_sname;
    private List<ActionEquipment> action_equip_list;

    public static EquipmentState toModel(EquipmentStateEntity entity){
        EquipmentState model = new EquipmentState();
        model.setEquip_state_id(entity.getEquip_state_id());
        model.setEquip_state_name(entity.getEquip_state_name());
        model.setEquip_state_sname(entity.getEquip_state_sname());
        model.setAction_equip_list(entity.getActionEquipmentEntityList().stream().map(ActionEquipment::toModel).collect(Collectors.toList()));
        return model;
    }

    public EquipmentState() {
    }

    public Integer getEquip_state_id() {
        return equip_state_id;
    }

    public void setEquip_state_id(Integer equip_state_id) {
        this.equip_state_id = equip_state_id;
    }

    public String getEquip_state_name() {
        return equip_state_name;
    }

    public void setEquip_state_name(String equip_state_name) {
        this.equip_state_name = equip_state_name;
    }

    public String getEquip_state_sname() {
        return equip_state_sname;
    }

    public void setEquip_state_sname(String equip_state_sname) {
        this.equip_state_sname = equip_state_sname;
    }

    public List<ActionEquipment> getAction_equip_list() {
        return action_equip_list;
    }

    public void setAction_equip_list(List<ActionEquipment> action_equip_list) {
        this.action_equip_list = action_equip_list;
    }
}
