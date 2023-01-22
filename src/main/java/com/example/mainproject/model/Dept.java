package com.example.mainproject.model;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.DeptTypeEntity;
import com.example.mainproject.entity.WellEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Dept {

    private Integer dept_id;
    private Integer dept_parent_id;
    private Integer dept_number;
    private String dept_name;
    private String dept_sname;

    private List<Well> well_list;

    public static Dept toModel(DeptEntity entity) {
        Dept model = new Dept();
        model.setDept_id(entity.getDept_id());
        model.setDept_parent_id(entity.getDept_parent_id());
        model.setDept_number(entity.getDept_number());
        model.setDept_name(entity.getDept_name());
        model.setDept_sname(entity.getDept_sname());
        model.setWell_list(entity.getWellEntityList().stream().map(Well::toModel).collect(Collectors.toList()));
        return model;
    }

    public Dept() {
    }

    public List<Well> getWell_list() {
        return well_list;
    }

    public void setWell_list(List<Well> well_list) {
        this.well_list = well_list;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getDept_parent_id() {
        return dept_parent_id;
    }

    public void setDept_parent_id(Integer dept_parent_id) {
        this.dept_parent_id = dept_parent_id;
    }

    public Integer getDept_number() {
        return dept_number;
    }

    public void setDept_number(Integer dept_number) {
        this.dept_number = dept_number;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_sname() {
        return dept_sname;
    }

    public void setDept_sname(String dept_sname) {
        this.dept_sname = dept_sname;
    }
}
