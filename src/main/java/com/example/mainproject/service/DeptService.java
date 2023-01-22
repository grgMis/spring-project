package com.example.mainproject.service;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.DeptTypeEntity;
import com.example.mainproject.entity.EquipmentCategoryEntity;
import com.example.mainproject.entity.EquipmentClassEntity;
import com.example.mainproject.model.Dept;
import com.example.mainproject.repository.DeptRepo;
import com.example.mainproject.repository.DeptTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptRepo deptRepo;

    @Autowired
    private DeptTypeRepo deptTypeRepo;

    public List<DeptEntity> getAll() {
        return (List<DeptEntity>) deptRepo.findAll();
    }

    public Dept createData(DeptEntity deptEntity, Integer id){
        DeptTypeEntity deptTypeEntity = deptTypeRepo.findById(id).get();
        deptEntity.setDept_type_id(deptTypeEntity);
        return Dept.toModel(deptRepo.save(deptEntity));
    }

    public Dept getOne(Integer id) {
        DeptEntity deptEntity = deptRepo.findById(id).get();
        return Dept.toModel(deptEntity);
    }

    public Integer deleteOne(Integer id){
        deptRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, DeptEntity deptEntity) {
        DeptEntity entity = deptRepo.findById(id).get();
        entity.setDept_parent_id(deptEntity.getDept_parent_id());
        entity.setDept_number(deptEntity.getDept_number());
        entity.setDept_name(deptEntity.getDept_name());
        entity.setDept_name(deptEntity.getDept_name());
        deptRepo.save(entity);
        return id;
    }

}
