package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ActionOperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer action_oper_id;

    @ManyToOne
    @JoinColumn(name = "action_id", nullable = false)
    private ActionEntity action_id;

    @ManyToOne
    @JoinColumn(name = "action_oper_type_id", nullable = false)
    private ActionOperationTypeEntity action_oper_type_id;

    @ManyToOne
    @JoinColumn(name = "hanger_type_id", nullable = true)
    private HangerTypeEntity hanger_type_id;

    @Column(nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date action_oper_date;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "action_oper_id")
    private List<ActionEquipmentEntity> actionEquipmentEntityList;

    public ActionOperationEntity() {
    }

    public List<ActionEquipmentEntity> getActionEquipmentEntityList() {
        return actionEquipmentEntityList;
    }

    public void setActionEquipmentEntityList(List<ActionEquipmentEntity> actionEquipmentEntityList) {
        this.actionEquipmentEntityList = actionEquipmentEntityList;
    }

    public Integer getAction_oper_id() {
        return action_oper_id;
    }

    public void setAction_oper_id(Integer action_oper_id) {
        this.action_oper_id = action_oper_id;
    }

    public ActionEntity getAction_id() {
        return action_id;
    }

    public void setAction_id(ActionEntity action_id) {
        this.action_id = action_id;
    }

    public ActionOperationTypeEntity getAction_oper_type_id() {
        return action_oper_type_id;
    }

    public void setAction_oper_type_id(ActionOperationTypeEntity action_oper_type_id) {
        this.action_oper_type_id = action_oper_type_id;
    }

    public HangerTypeEntity getHanger_type_id() {
        return hanger_type_id;
    }

    public void setHanger_type_id(HangerTypeEntity hanger_type_id) {
        this.hanger_type_id = hanger_type_id;
    }

    public Date getAction_oper_date() {
        return action_oper_date;
    }

    public void setAction_oper_date(Date action_oper_date) {
        this.action_oper_date = action_oper_date;
    }
}
