package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class WellEquipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer well_equip_id;

    @ManyToOne
    @JoinColumn(name = "well_id", nullable = false)
    private WellEntity well_id;

    @ManyToOne
    @JoinColumn(name = "equip_id", nullable = false)
    private EquipmentEntity equip_id;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "well_equip_id")
    private List<ActionEquipmentEntity> actionEquipmentEntityList;

    public WellEquipEntity() {
    }

    public List<ActionEquipmentEntity> getActionEquipmentEntityList() {
        return actionEquipmentEntityList;
    }

    public void setActionEquipmentEntityList(List<ActionEquipmentEntity> actionEquipmentEntityList) {
        this.actionEquipmentEntityList = actionEquipmentEntityList;
    }

    public Integer getWell_equip_id() {
        return well_equip_id;
    }

    public void setWell_equip_id(Integer well_equip_id) {
        this.well_equip_id = well_equip_id;
    }

    public WellEntity getWell_id() {
        return well_id;
    }

    public void setWell_id(WellEntity well_id) {
        this.well_id = well_id;
    }

    public EquipmentEntity getEquip_id() {
        return equip_id;
    }

    public void setEquip_id(EquipmentEntity equip_id) {
        this.equip_id = equip_id;
    }
}
