package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class EquipmentModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equip_model_id;

    @ManyToOne
    @JoinColumn(name = "equip_class_id", nullable = false)
    private EquipmentClassEntity equip_class_id;

    @Column(nullable = false, length = 40)
    private String equip_model_name;

    @Column(nullable = true, length = 20)
    private String equip_model_sname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equip_model_id")
    private List<EquipmentEntity> equipmentEntityList;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equip_model_id")
    private List<ActionEquipmentEntity> actionEquipmentEntityList;

    public EquipmentModelEntity() {
    }

    public List<EquipmentEntity> getEquipmentEntityList() {
        return equipmentEntityList;
    }

    public void setEquipmentEntityList(List<EquipmentEntity> equipmentEntityList) {
        this.equipmentEntityList = equipmentEntityList;
    }

    public List<ActionEquipmentEntity> getActionEquipmentEntityList() {
        return actionEquipmentEntityList;
    }

    public void setActionEquipmentEntityList(List<ActionEquipmentEntity> actionEquipmentEntityList) {
        this.actionEquipmentEntityList = actionEquipmentEntityList;
    }

    public Integer getEquip_model_id() {
        return equip_model_id;
    }

    public void setEquip_model_id(Integer equip_model_id) {
        this.equip_model_id = equip_model_id;
    }

    public EquipmentClassEntity getEquip_class_id() {
        return equip_class_id;
    }

    public void setEquip_class_id(EquipmentClassEntity equip_class_id) {
        this.equip_class_id = equip_class_id;
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
}
