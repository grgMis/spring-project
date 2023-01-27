package com.example.mainproject.repository;

import com.example.mainproject.entity.UserDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDataRepo extends CrudRepository<UserDataEntity, Integer> {
}
