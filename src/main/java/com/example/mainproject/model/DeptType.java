package com.example.mainproject.model;

import com.example.mainproject.entity.DeptTypeEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DeptType {

    private Integer dept_type_id;
    private String dept_type_name;
    private String dept_type_sname;

    private List<Dept> dept_list;

    public static DeptType toModel(DeptTypeEntity entity) {
        DeptType model = new DeptType();
        model.setDept_type_id(entity.getDept_type_id());
        model.setDept_type_name(entity.getDept_type_name());
        model.setDept_type_sname(entity.getDept_type_sname());
        model.setDept_list(entity.getDeptEntityList().stream().map(Dept::toModel).collect(Collectors.toList()));
        return model;
    }

    public DeptType() {
    }

    public List<Dept> getDept_list() {
        return dept_list;
    }

    public void setDept_list(List<Dept> dept_list) {
        this.dept_list = dept_list;
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
