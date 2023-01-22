package com.example.mainproject.repository;

import com.example.mainproject.entity.DeptEntity;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepo extends CrudRepository<DeptEntity, Integer> {
}
