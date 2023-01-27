package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class EquipmentStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equip_state_id;

    @Column(nullable = false, length = 40)
    private String equip_state_name;

    @Column(nullable = true, length = 20)
    private String equip_state_sname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equip_state_id")
    private List<EquipmentEntity> equipmentEntityList;

    public EquipmentStateEntity() {
    }

    public List<EquipmentEntity> getEquipmentEntityList() {
        return equipmentEntityList;
    }

    public void setEquipmentEntityList(List<EquipmentEntity> equipmentEntityList) {
        this.equipmentEntityList = equipmentEntityList;
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
}
