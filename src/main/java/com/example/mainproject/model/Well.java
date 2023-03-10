package com.example.mainproject.model;

import com.example.mainproject.entity.ActionOperationTypeEntity;
import com.example.mainproject.entity.WellEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Well {

    private Integer well_id;
    private String well_name;

    public static Well toModel(WellEntity entity){
        Well model = new Well();
        model.setWell_id(entity.getWell_id());
        model.setWell_name(entity.getWell_name());
        return model;
    }

    public Well() {
    }

    public Integer getWell_id() {
        return well_id;
    }

    public void setWell_id(Integer well_id) {
        this.well_id = well_id;
    }

    public String getWell_name() {
        return well_name;
    }

    public void setWell_name(String well_name) {
        this.well_name = well_name;
    }

}
