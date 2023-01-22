package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.IndexColumn;

import java.util.List;

@Entity
public class ActionGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer action_group_id;

    @Column(nullable = false, length = 40)
    private String action_group_name;

    @Column(nullable = true, length = 20)
    private String action_group_sname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "action_group_id")
    private List<ActionTypeEntity> actionTypeEntitiesList;

    public ActionGroupEntity() {
    }

    public List<ActionTypeEntity> getActionTypeEntitiesList() {
        return actionTypeEntitiesList;
    }

    public void setActionTypeEntitiesList(List<ActionTypeEntity> actionTypeEntitiesList) {
        this.actionTypeEntitiesList = actionTypeEntitiesList;
    }

    public Integer getAction_group_id() {
        return action_group_id;
    }

    public void setAction_group_id(Integer action_group_id) {
        this.action_group_id = action_group_id;
    }

    public String getAction_group_name() {
        return action_group_name;
    }

    public void setAction_group_name(String action_group_name) {
        this.action_group_name = action_group_name;
    }

    public String getAction_group_sname() {
        return action_group_sname;
    }

    public void setAction_group_sname(String action_group_sname) {
        this.action_group_sname = action_group_sname;
    }
}
