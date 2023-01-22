package com.example.mainproject.model;

import com.example.mainproject.entity.EquipmentEntity;
import com.example.mainproject.entity.EquipmentModelEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Equipment {
    private Integer equip_id;
    private String factory_number;
    private String inventory_number;
    private List<ActionEquipment> action_equip_list;

    public static Equipment toModel(EquipmentEntity entity){
        Equipment model = new Equipment();
        model.setEquip_id(entity.getEquip_id());
        model.setFactory_number(entity.getFactory_number());
        model.setInventory_number(entity.getInventory_number());
        model.setAction_equip_list(entity.getActionEquipmentEntityList().stream().map(ActionEquipment::toModel).collect(Collectors.toList()));
        return model;
    }

    public Equipment() {
    }

    public Integer getEquip_id() {
        return equip_id;
    }

    public void setEquip_id(Integer equip_id) {
        this.equip_id = equip_id;
    }

    public String getFactory_number() {
        return factory_number;
    }

    public void setFactory_number(String factory_number) {
        this.factory_number = factory_number;
    }

    public String getInventory_number() {
        return inventory_number;
    }

    public void setInventory_number(String inventory_number) {
        this.inventory_number = inventory_number;
    }

    public List<ActionEquipment> getAction_equip_list() {
        return action_equip_list;
    }

    public void setAction_equip_list(List<ActionEquipment> action_equip_list) {
        this.action_equip_list = action_equip_list;
    }
}
