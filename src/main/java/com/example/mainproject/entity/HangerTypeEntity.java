package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class HangerTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hanger_type_id;

    @Column(nullable = false, length = 20)
    private String hanger_type_name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hanger_type_id")
    private List<ActionOperationEntity> actionOperationEntityList;

    public HangerTypeEntity() {
    }

    public List<ActionOperationEntity> getActionOperationEntityList() {
        return actionOperationEntityList;
    }

    public void setActionOperationEntityList(List<ActionOperationEntity> actionOperationEntityList) {
        this.actionOperationEntityList = actionOperationEntityList;
    }

    public Integer getHanger_type_id() {
        return hanger_type_id;
    }

    public void setHanger_type_id(Integer hanger_type_id) {
        this.hanger_type_id = hanger_type_id;
    }

    public String getHanger_type_name() {
        return hanger_type_name;
    }

    public void setHanger_type_name(String hanger_type_name) {
        this.hanger_type_name = hanger_type_name;
    }
}
