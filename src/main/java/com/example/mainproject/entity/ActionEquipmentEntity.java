package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ActionEquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer action_equip_id;

    @ManyToOne
    @JoinColumn(name = "action_oper_id", nullable = false)
    private ActionOperationEntity action_oper_id;

    @Column(nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date equip_date_entry;

    @ManyToOne
    @JoinColumn(name = "equip_class_id", nullable = false)
    private EquipmentClassEntity equip_class_id;

    @ManyToOne
    @JoinColumn(name = "equip_model_id", nullable = true)
    private EquipmentModelEntity equip_model_id;

    @ManyToOne
    @JoinColumn(name = "equip_id", nullable = true)
    private EquipmentEntity equip_id;

    @Column(nullable = false)
    private Integer equip_no;

    @ManyToOne
    @JoinColumn(name = "equip_state_id", nullable = true)
    private EquipmentStateEntity equip_state_id;

    @Column(nullable = true)
    private float equip_depth_begin;

    @Column(nullable = true)
    private float equip_depth_end;

    @Column(nullable = true)
    private Integer equip_count;

    public ActionEquipmentEntity() {
    }

    public Integer getAction_equip_id() {
        return action_equip_id;
    }

    public void setAction_equip_id(Integer action_equip_id) {
        this.action_equip_id = action_equip_id;
    }

    public ActionOperationEntity getAction_oper_id() {
        return action_oper_id;
    }

    public void setAction_oper_id(ActionOperationEntity action_oper_id) {
        this.action_oper_id = action_oper_id;
    }

    public Date getEquip_date_entry() {
        return equip_date_entry;
    }

    public void setEquip_date_entry(Date equip_date_entry) {
        this.equip_date_entry = equip_date_entry;
    }

    public EquipmentClassEntity getEquip_class_id() {
        return equip_class_id;
    }

    public void setEquip_class_id(EquipmentClassEntity equip_class_id) {
        this.equip_class_id = equip_class_id;
    }

    public EquipmentModelEntity getEquip_model_id() {
        return equip_model_id;
    }

    public void setEquip_model_id(EquipmentModelEntity equip_model_id) {
        this.equip_model_id = equip_model_id;
    }

    public EquipmentEntity getEquip_id() {
        return equip_id;
    }

    public void setEquip_id(EquipmentEntity equip_id) {
        this.equip_id = equip_id;
    }

    public Integer getEquip_no() {
        return equip_no;
    }

    public void setEquip_no(Integer equip_no) {
        this.equip_no = equip_no;
    }

    public EquipmentStateEntity getEquip_state_id() {
        return equip_state_id;
    }

    public void setEquip_state_id(EquipmentStateEntity equip_state_id) {
        this.equip_state_id = equip_state_id;
    }

    public float getEquip_depth_begin() {
        return equip_depth_begin;
    }

    public void setEquip_depth_begin(float equip_depth_begin) {
        this.equip_depth_begin = equip_depth_begin;
    }

    public float getEquip_depth_end() {
        return equip_depth_end;
    }

    public void setEquip_depth_end(float equip_depth_end) {
        this.equip_depth_end = equip_depth_end;
    }

    public Integer getEquip_count() {
        return equip_count;
    }

    public void setEquip_count(Integer equip_count) {
        this.equip_count = equip_count;
    }
}
