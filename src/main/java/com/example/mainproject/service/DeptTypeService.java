package com.example.mainproject.service;

import com.example.mainproject.entity.DeptTypeEntity;
import com.example.mainproject.exception.DeptTypeNotFoundException;
import com.example.mainproject.model.DeptType;
import com.example.mainproject.repository.DeptTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptTypeService {

    @Autowired
    private DeptTypeRepo deptTypeRepo;

    public List<DeptTypeEntity> getAll() {
        return (List<DeptTypeEntity>) deptTypeRepo.findAll();
    }
    
    public DeptType addData(DeptTypeEntity deptType) {
        return DeptType.toModel(deptTypeRepo.save(deptType));
    }

    public DeptType getOne(Integer id) throws DeptTypeNotFoundException {
        DeptTypeEntity deptType = deptTypeRepo.findById(id).get();
        if (deptType == null) {
            throw new DeptTypeNotFoundException("Такой тип оборудования не найден");
        }
        return DeptType.toModel(deptType);
    }

    public Integer deleteOne(Integer id) throws DeptTypeNotFoundException {
        DeptTypeEntity deptType = deptTypeRepo.findById(id).get();
        if (deptType == null) {
            throw new DeptTypeNotFoundException("Такой тип оборудования не найден");
        }
        deptTypeRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, DeptTypeEntity deptType) {
        DeptTypeEntity entity = deptTypeRepo.findById(id).get();
        entity.setDept_type_name(deptType.getDept_type_name());
        entity.setDept_type_sname(deptType.getDept_type_sname());
        deptTypeRepo.save(entity);
        return id;
    }
}
