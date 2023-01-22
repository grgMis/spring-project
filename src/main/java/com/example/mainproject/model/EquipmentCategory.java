package com.example.mainproject.model;

import com.example.mainproject.entity.EquipmentCategoryEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EquipmentCategory {

    private Integer equip_category_id;
    private String equip_category_name;
    private String equip_category_sname;

    private List<EquipmentClass> equip_class_list;

    public static EquipmentCategory toModel(EquipmentCategoryEntity entity){
        EquipmentCategory model = new EquipmentCategory();
        model.setEquip_category_id(entity.getEquip_category_id());
        model.setEquip_category_name(entity.getEquip_category_name());
        model.setEquip_category_sname(entity.getEquip_category_sname());
        model.setEquip_class_list(entity.getEquipmentClassEntityList().stream().map(EquipmentClass::toModel).collect(Collectors.toList()));
        return model;
    }
    public EquipmentCategory() {
    }

    public Integer getEquip_category_id() {
        return equip_category_id;
    }

    public void setEquip_category_id(Integer equip_category_id) {
        this.equip_category_id = equip_category_id;
    }

    public String getEquip_category_name() {
        return equip_category_name;
    }

    public void setEquip_category_name(String equip_category_name) {
        this.equip_category_name = equip_category_name;
    }

    public String getEquip_category_sname() {
        return equip_category_sname;
    }

    public void setEquip_category_sname(String equip_category_sname) {
        this.equip_category_sname = equip_category_sname;
    }

    public List<EquipmentClass> getEquip_class_list() {
        return equip_class_list;
    }

    public void setEquip_class_list(List<EquipmentClass> equip_class_list) {
        this.equip_class_list = equip_class_list;
    }
}
