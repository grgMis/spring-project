package com.example.mainproject.model;

import com.example.mainproject.entity.EquipmentModelEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EquipmentModel {

    private Integer equip_model_id;
    private String equip_model_name;
    private String equip_model_sname;
    private List<Equipment> equip_list;
    private List<ActionEquipment> action_equip_list;

    public static EquipmentModel toModel(EquipmentModelEntity entity){
        EquipmentModel model = new EquipmentModel();
        model.setEquip_model_id(entity.getEquip_model_id());
        model.setEquip_model_name(entity.getEquip_model_name());
        model.setEquip_model_sname(entity.getEquip_model_sname());
        model.setEquip_list(entity.getEquipmentEntityList().stream().map(Equipment::toModel).collect(Collectors.toList()));
        model.setAction_equip_list(entity.getActionEquipmentEntityList().stream().map(ActionEquipment::toModel).collect(Collectors.toList()));
        return model;
    }

    public EquipmentModel() {
    }

    public Integer getEquip_model_id() {
        return equip_model_id;
    }

    public void setEquip_model_id(Integer equip_model_id) {
        this.equip_model_id = equip_model_id;
    }

    public String getEquip_model_name() {
        return equip_model_name;
    }

    public void setEquip_model_name(String equip_model_name) {
        this.equip_model_name = equip_model_name;
    }

    public String getEquip_model_sname() {
        return equip_model_sname;
    }

    public void setEquip_model_sname(String equip_model_sname) {
        this.equip_model_sname = equip_model_sname;
    }

    public List<Equipment> getEquip_list() {
        return equip_list;
    }

    public void setEquip_list(List<Equipment> equip_list) {
        this.equip_list = equip_list;
    }

    public List<ActionEquipment> getAction_equip_list() {
        return action_equip_list;
    }

    public void setAction_equip_list(List<ActionEquipment> action_equip_list) {
        this.action_equip_list = action_equip_list;
    }
}
