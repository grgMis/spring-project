package com.example.mainproject.service;

import com.example.mainproject.entity.DeptEntity;
import com.example.mainproject.entity.HangerTypeEntity;
import com.example.mainproject.model.HangerType;
import com.example.mainproject.repository.HangerTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangerTypeService {

    @Autowired
    private HangerTypeRepo hangerTypeRepo;

    public List<HangerTypeEntity> getAll() {
        return (List<HangerTypeEntity>) hangerTypeRepo.findAll();
    }

    public HangerType addData(HangerTypeEntity hangerType) {
        return HangerType.toModel(hangerTypeRepo.save(hangerType));
    }

    public HangerType getOne(Integer id) {
        HangerTypeEntity hangerType = hangerTypeRepo.findById(id).get();
        return HangerType.toModel(hangerType);
    }

    public Integer deleteOne(Integer id){
        hangerTypeRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, HangerTypeEntity hangerType) {
        HangerTypeEntity entity = hangerTypeRepo.findById(id).get();
        entity.setHanger_type_name(hangerType.getHanger_type_name());
        hangerTypeRepo.save(entity);
        return id;
    }
}
