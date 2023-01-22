package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class WellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer well_id;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private DeptEntity dept_id;

    @Column(nullable = false, length = 20)
    private String well_name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "well_id")
    private List<ActionEntity> actionEntityList;

    public WellEntity() {
    }

    public List<ActionEntity> getActionEntityList() {
        return actionEntityList;
    }

    public void setActionEntityList(List<ActionEntity> actionEntityList) {
        this.actionEntityList = actionEntityList;
    }

    public Integer getWell_id() {
        return well_id;
    }

    public void setWell_id(Integer well_id) {
        this.well_id = well_id;
    }

    public DeptEntity getDept_id() {
        return dept_id;
    }

    public void setDept_id(DeptEntity dept_id) {
        this.dept_id = dept_id;
    }

    public String getWell_name() {
        return well_name;
    }

    public void setWell_name(String well_name) {
        this.well_name = well_name;
    }
}
