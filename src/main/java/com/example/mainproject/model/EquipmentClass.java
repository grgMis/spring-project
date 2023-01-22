package com.example.mainproject.model;

import com.example.mainproject.entity.EquipmentCategoryEntity;
import com.example.mainproject.entity.EquipmentClassEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EquipmentClass {

    private Integer equip_class_id;
    private String equip_class_name;
    private String equip_class_sname;
    private List<EquipmentModel> equip_model_list;
    private List<ActionEquipment> action_equip_list;

    public static EquipmentClass toModel(EquipmentClassEntity entity){
        EquipmentClass model = new EquipmentClass();
        model.setEquip_class_id(entity.getEquip_class_id());
        model.setEquip_class_name(entity.getEquip_class_name());
        model.setEquip_class_sname(entity.getEquip_class_sname());
        model.setEquip_model_list(entity.getEquipmentModelEntityList().stream().map(EquipmentModel::toModel).collect(Collectors.toList()));
        model.setAction_equip_list(entity.getActionEquipmentEntityList().stream().map(ActionEquipment::toModel).collect(Collectors.toList()));
        return model;
    }

    public EquipmentClass() {
    }

    public Integer getEquip_class_id() {
        return equip_class_id;
    }

    public void setEquip_class_id(Integer equip_class_id) {
        this.equip_class_id = equip_class_id;
    }

    public String getEquip_class_name() {
        return equip_class_name;
    }

    public void setEquip_class_name(String equip_class_name) {
        this.equip_class_name = equip_class_name;
    }

    public String getEquip_class_sname() {
        return equip_class_sname;
    }

    public void setEquip_class_sname(String equip_class_sname) {
        this.equip_class_sname = equip_class_sname;
    }

    public List<EquipmentModel> getEquip_model_list() {
        return equip_model_list;
    }

    public void setEquip_model_list(List<EquipmentModel> equip_model_list) {
        this.equip_model_list = equip_model_list;
    }

    public List<ActionEquipment> getAction_equip_list() {
        return action_equip_list;
    }

    public void setAction_equip_list(List<ActionEquipment> action_equip_list) {
        this.action_equip_list = action_equip_list;
    }
}
