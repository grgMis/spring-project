package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class DeptTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dept_type_id;

    @Column(nullable = false, length = 40)
    private String dept_type_name;

    @Column(nullable = true, length = 20)
    private String dept_type_sname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dept_type_id")
    private List<DeptEntity> deptEntityList;


    public DeptTypeEntity() {
    }

    public List<DeptEntity> getDeptEntityList() {
        return deptEntityList;
    }

    public void setDeptEntityList(List<DeptEntity> deptEntityList) {
        this.deptEntityList = deptEntityList;
    }

    public Integer getDept_type_id() {
        return dept_type_id;
    }

    public void setDept_type_id(Integer dept_type_id) {
        this.dept_type_id = dept_type_id;
    }

    public String getDept_type_name() {
        return dept_type_name;
    }

    public void setDept_type_name(String dept_type_name) {
        this.dept_type_name = dept_type_name;
    }

    public String getDept_type_sname() {
        return dept_type_sname;
    }

    public void setDept_type_sname(String dept_type_sname) {
        this.dept_type_sname = dept_type_sname;
    }
}
