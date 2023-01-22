package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class EquipmentCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equip_category_id;

    @Column(nullable = false, length = 40)
    private String equip_category_name;

    @Column(nullable = true, length = 20)
    private String equip_category_sname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equip_category_id")
    private List<EquipmentClassEntity> equipmentClassEntityList;

    public EquipmentCategoryEntity() {
    }

    public List<EquipmentClassEntity> getEquipmentClassEntityList() {
        return equipmentClassEntityList;
    }

    public void setEquipmentClassEntityList(List<EquipmentClassEntity> equipmentClassEntityList) {
        this.equipmentClassEntityList = equipmentClassEntityList;
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
}
