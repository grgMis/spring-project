package com.example.mainproject.service;

import com.example.mainproject.entity.UserDataEntity;
import com.example.mainproject.repository.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepo userDataRepo;

    public List<UserDataEntity> getAll() {
        return (List<UserDataEntity>) userDataRepo.findAll();
    }

    public UserDataEntity addData(UserDataEntity userData) {
        return userDataRepo.save(userData);
    }

    public UserDataEntity getOne(Integer id) {
        UserDataEntity userDataEntity = userDataRepo.findById(id).get();
        return userDataEntity;
    }

    public Integer deleteOne(Integer id){
        userDataRepo.deleteById(id);
        return id;
    }

    public Integer updateData(Integer id, UserDataEntity userData) {
        UserDataEntity entity = userDataRepo.findById(id).get();
        entity.setUser_data_login(userData.getUser_data_login());
        entity.setUser_data_password(userData.getUser_data_password());
        userDataRepo.save(entity);
        return id;
    }

}
