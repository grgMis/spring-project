package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class EquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equip_id;

    @ManyToOne
    @JoinColumn(name = "equip_model_id", nullable = false)
    private EquipmentModelEntity equip_model_id;

    @ManyToOne
    @JoinColumn(name = "equip_state_id", nullable = false)
    private EquipmentStateEntity equip_state_id;

    @Column(nullable = true, length = 20)
    private String factory_number;

    @Column(nullable = true, length = 40)
    private String inventory_number;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equip_id")
    private List<WellEquipEntity> wellEquipEntityList;

    public EquipmentEntity() {
    }
    public EquipmentStateEntity getEquip_state_id() {
        return equip_state_id;
    }

    public void setEquip_state_id(EquipmentStateEntity equip_state_id) {
        this.equip_state_id = equip_state_id;
    }

    public void setWellEquipEntityList(List<WellEquipEntity> wellEquipEntityList) {
        this.wellEquipEntityList = wellEquipEntityList;
    }

    public List<WellEquipEntity> getWellEquipEntityList() {
        return wellEquipEntityList;
    }

    public Integer getEquip_id() {
        return equip_id;
    }

    public void setEquip_id(Integer equip_id) {
        this.equip_id = equip_id;
    }

    public EquipmentModelEntity getEquip_model_id() {
        return equip_model_id;
    }

    public void setEquip_model_id(EquipmentModelEntity equip_model_id) {
        this.equip_model_id = equip_model_id;
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
}
