package com.example.mainproject.service;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.EquipmentCategoryEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.entity.WellEntity;
import com.example.mainproject.model.Well;
import com.example.mainproject.repository.DeptRepo;
import com.example.mainproject.repository.WellRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WellService {

    @Autowired
    private WellRepo wellRepo;

    @Autowired
    private DeptRepo deptRepo;

    public List<WellEntity> getAll() {
        return (List<WellEntity>) wellRepo.findAll();
    }

    public Well createData(WellEntity wellEntity, Integer id){
        DeptEntity deptEntity = deptRepo.findById(id).get();
        wellEntity.setDept_id(deptEntity);
        return Well.toModel(wellRepo.save(wellEntity));
    }

    public Well getOne(Integer id) {
        WellEntity wellEntity = wellRepo.findById(id).get();
        return Well.toModel(wellEntity);
    }

    public Integer deleteOne(Integer id){
        wellRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, WellEntity wellEntity) {
        WellEntity entity = wellRepo.findById(id).get();
        entity.setWell_name(wellEntity.getWell_name());
        wellRepo.save(entity);
        return id;
    }
}
