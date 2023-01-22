package com.example.mainproject.repository;

import com.example.mainproject.entity.WellEntity;
import org.springframework.data.repository.CrudRepository;

public interface WellRepo extends CrudRepository<WellEntity, Integer> {
}
